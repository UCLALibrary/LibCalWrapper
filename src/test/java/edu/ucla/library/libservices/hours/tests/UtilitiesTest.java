package edu.ucla.library.libservices.hours.tests;

import edu.ucla.library.libservices.hours.utility.EmptyChecker;

import edu.ucla.library.libservices.hours.utility.OpenChecker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UtilitiesTest
{
  @Test
  public void isEmptyStringWorks()
  {
        assertTrue(EmptyChecker.isEmpty(""), "isEmpty{\"\") should return true");
        assertFalse(EmptyChecker.isEmpty("this has content"), "isEmpty{\"this has content\") should return false");
  }

  @Test
  public void isEmptyObjectWorks()
  {
        assertTrue(EmptyChecker.isEmpty(null), "isEmpty{null) should return true");
        assertFalse(EmptyChecker.isEmpty(new Integer("5")), "isEmpty{new Integer(\"5\")) should return false");
  }

  @Test
  public void isLibraryOpenWorks()
  {
    assertTrue(OpenChecker.isLibraryOpen("fromDate", "toDate", "24hours"), "'24hours' should report true/open");
    assertFalse(OpenChecker.isLibraryOpen("fromDate", "toDate", "closed"), "'closed' should report false/closed");
    assertFalse(OpenChecker.isLibraryOpen("fromDate", "toDate", "not-set"), "'not-set' should report false/closed");
    assertFalse(OpenChecker.isLibraryOpen("fromDate", "toDate", "text"), "'text' should report false/closed");
    assertFalse(OpenChecker.isLibraryOpen("fromDate", "toDate", "ByApp"), "'ByApp' should report false/closed");
    assertFalse(OpenChecker.isLibraryOpen("fromDate", "toDate", ""), "'' should report false/closed");
    assertFalse(OpenChecker.isLibraryOpen("06/23/2020", "06/24/2020", "Open"),"non-'yyyy-mm-dd' format should return false");
  }
}
