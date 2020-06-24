package edu.ucla.library.libservices.hours.tests;

import edu.ucla.library.libservices.hours.beans.DailyLocationRoot;
import edu.ucla.library.libservices.hours.clients.DailyHoursClient;

import edu.ucla.library.libservices.hours.exceptions.LibCalException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class DailyHoursTest
{
  private static final int INSTITUTION_ID = 3244;
  private static final int BAD_INSTITUTION_ID = -1;
  private static final int LOCATION_ID = 2572;
  private static final int BAD_LOCATION_ID = -1;
  private static final String BAD_GATEWAY = "502";

  private static DailyHoursClient docMaker;

  @BeforeEach
  void init()
  {
    docMaker = new DailyHoursClient();
  }

  @Test
  public void dailyClientReturnsObject()
    throws LibCalException
  {
    DailyLocationRoot root;

    docMaker.setInstitutionID(INSTITUTION_ID);
    docMaker.setLocationID(LOCATION_ID);
    root = docMaker.getTheLocation();

    assertNotNull(root, "docMaker.getTheLocation(3244,2572) should return object");
    assertTrue(root.getLocations()
                   .stream()
                   .anyMatch(n -> n.getName().equals("Powell Library")),
               "docMaker.getTheLocation(3244,2572) should contain Powell");
  }

  @Test
  public void badLibIdReturnsNull()
    //throws LibCalException
  {
    docMaker.setInstitutionID(BAD_INSTITUTION_ID);
    docMaker.setLocationID(LOCATION_ID);
    Exception exception = assertThrows(LibCalException.class, () -> { docMaker.getTheLocation(); });
    assertTrue(exception.getMessage().contains(BAD_GATEWAY));
  }

  @Test
  public void badLocIdReturnsObject()
    throws LibCalException
  {
    docMaker.setInstitutionID(INSTITUTION_ID);
    docMaker.setLocationID(BAD_LOCATION_ID);
    assertNotNull(docMaker.getTheLocation(), "docMaker.getTheLocation(-1,-1) shouldn't return object");
  }
}
