package edu.ucla.library.libservices.hours.tests;

import edu.ucla.library.libservices.hours.clients.UnitsClient;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class UnitClientTest
{
  private static final int INSTITUTION_ID = 3244;
  private static final int BAD_ID = -1;
  private static UnitsClient docMaker;

  @BeforeEach
  void init()
  {
    docMaker = new UnitsClient();
  }

  @Test
  public void unitsClientReturnsObject()
  {
    docMaker.setInstitutionID(INSTITUTION_ID);
    assertNotNull(docMaker.getTheUnits(), "docMaker.getTheUnits(3244) should return object");
    assertTrue(docMaker.getTheUnits()
                       .getUnits()
                       .stream()
                       .anyMatch(n -> n.getName().equals("Powell Library")),
               "docMaker.getTheUnits(3244) should contain Powell");
  }

  @Test
  public void badIdReturnsNull()
  {
    docMaker.setInstitutionID(BAD_ID);
    assertNull(docMaker.getTheUnits(), "docMaker.getTheUnits(-1) shouldn't return object");
  }
}
