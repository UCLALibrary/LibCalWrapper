package edu.ucla.library.libservices.hours.tests;

import edu.ucla.library.libservices.hours.beans.DailyLocation;
import edu.ucla.library.libservices.hours.beans.DailyLocationRoot;
import edu.ucla.library.libservices.hours.beans.DayOfWeek;
import edu.ucla.library.libservices.hours.beans.Hour;
import edu.ucla.library.libservices.hours.beans.Time;
import edu.ucla.library.libservices.hours.beans.Unit;
import edu.ucla.library.libservices.hours.beans.UnitRoot;
import edu.ucla.library.libservices.hours.beans.Week;
import edu.ucla.library.libservices.hours.beans.WeeklyLocation;
import edu.ucla.library.libservices.hours.beans.WeeklyLocationRoot;

import org.junit.jupiter.api.Test;

import org.meanbean.test.BeanTester;


public class BeanAccessTest
{
  @Test
  public void dailyLocationAccessMethodsWork()
  {
    new BeanTester().testBean(DailyLocation.class);
  }

  @Test
  public void dailyLocationRootAccessMethodsWork()
  {
    new BeanTester().testBean(DailyLocationRoot.class);
  }

  @Test
  public void dayOfWeekAccessMethodsWork()
  {
    new BeanTester().testBean(DayOfWeek.class);
  }

  @Test
  public void hourAccessMethodsWork()
  {
    new BeanTester().testBean(Hour.class);
  }

  @Test
  public void timeAccessMethodsWork()
  {
    new BeanTester().testBean(Time.class);
  }

  @Test
  public void unitAccessMethodsWork()
  {
    new BeanTester().testBean(Unit.class);
  }

  @Test
  public void unitRootAccessMethodsWork()
  {
    new BeanTester().testBean(UnitRoot.class);
  }

  @Test
  public void weekAccessMethodsWork()
  {
    new BeanTester().testBean(Week.class);
  }

  @Test
  public void weeklyLocationAccessMethodsWork()
  {
    new BeanTester().testBean(WeeklyLocation.class);
  }

  @Test
  public void weeklyLocationRootAccessMethodsWork()
  {
    new BeanTester().testBean(WeeklyLocationRoot.class);
  }

}
