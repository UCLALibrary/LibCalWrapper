package edu.ucla.library.libservices.hours.tests;

import edu.ucla.library.libservices.hours.beans.WeeklyLocationRoot;
import edu.ucla.library.libservices.hours.clients.WeeklyLocationClient;
import edu.ucla.library.libservices.hours.exceptions.LibCalException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class WeeklyClientTest
{
  private static final int INSTITUTION_ID = 3244;
  private static final int BAD_INSTITUTION_ID = -1;
  private static final int LOCATION_ID = 2572;
  private static final int BAD_LOCATION_ID = -1;
  private static final int WEEKS = 1;
  private static final int BAD_WEEKS = -1;
  private static final String BAD_GATEWAY = "502";

  private static WeeklyLocationClient docMaker;

  @BeforeEach
  void init()
  {
    docMaker = new WeeklyLocationClient();
  }

  @Test
  public void weeklyClientReturnsObject()
    throws LibCalException
  {
    WeeklyLocationRoot root;

    docMaker.setInstitutionID(INSTITUTION_ID);
    docMaker.setLocationID(LOCATION_ID);
    docMaker.setWeeksCount(WEEKS);
    root = docMaker.getTheLocation();

    assertNotNull(root, "WeeklyLocationClient.getTheLocation(3244,2572,1) should return object");
    assertTrue(root.getLocations()
                   .stream()
                   .anyMatch(n -> n.getName().equals("Powell Library")),
               "WeeklyLocationClient.getTheLocation(3244,2572,1) should contain Powell");
  }

  @Test
  public void badLibIdReturnsEmpty()
  {
    WeeklyLocationRoot root;

    docMaker.setInstitutionID(BAD_INSTITUTION_ID);
    docMaker.setLocationID(LOCATION_ID);
    docMaker.setWeeksCount(WEEKS);
    root = docMaker.getTheLocation();

    assertNotNull(root, "WeeklyLocationClient.getTheLocation(-1,2572,1) should return object");
    assertTrue(root.getLocations().size() == 0, "WeeklyLocationClient.getTheLocation(-1,2572,1) should return empty list" );
  }

  @Test
  public void badLocIdReturnsObject()
    throws LibCalException
  {
    WeeklyLocationRoot root;

    docMaker.setInstitutionID(INSTITUTION_ID);
    docMaker.setLocationID(BAD_LOCATION_ID);
    docMaker.setWeeksCount(WEEKS);
    root = docMaker.getTheLocation();

    assertNotNull(root, "WeeklyLocationClient.getTheLocation(3244,-1,1) should return object");
    assertTrue(root.getLocations()
                   .stream()
                   .anyMatch(n -> n.getName().equals("Powell Library")),
               "WeeklyLocationClient.getTheLocation(3244,-1,1) should contain Powell");
  }

  @Test
  public void badWeeksReturnsNull()
  {
    WeeklyLocationRoot root;

    docMaker.setInstitutionID(INSTITUTION_ID);
    docMaker.setLocationID(BAD_LOCATION_ID);
    docMaker.setWeeksCount(BAD_WEEKS);
    root = docMaker.getTheLocation();

    assertNotNull(root, "WeeklyLocationClient.getTheLocation3244,2572,-11) should return object");
    assertTrue(root.getLocations().size() == 0, "WeeklyLocationClient.getTheLocation(3244,2572,-11) should return empty list" );
  }
}
