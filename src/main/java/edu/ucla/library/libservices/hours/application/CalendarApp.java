package edu.ucla.library.libservices.hours.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import edu.ucla.library.libservices.hours.services.HoursService;
import edu.ucla.library.libservices.hours.services.UnitsService;
import edu.ucla.library.libservices.hours.beans.DailyLocationRoot;
import edu.ucla.library.libservices.hours.beans.UnitRoot;
import edu.ucla.library.libservices.hours.beans.WeeklyLocationRoot;

@ApplicationPath( "/calendar" )
public class CalendarApp
  extends Application
{
  public CalendarApp()
  {
    super();
  }

  @Override
  public Set<Class<?>> getClasses()
  {
    final Set<Class<?>> classes = new HashSet<Class<?>>();
    // register root resources/providers
    classes.add( HoursService.class );
    classes.add( UnitsService.class );
    classes.add( DailyLocationRoot.class );
    classes.add( UnitRoot.class );
    classes.add( WeeklyLocationRoot.class );

    return classes;
  }
}
