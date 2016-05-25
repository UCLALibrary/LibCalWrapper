package edu.ucla.library.libservices.hours.testing;

import edu.ucla.library.libservices.hours.beans.WeeklyLocation;
import edu.ucla.library.libservices.hours.beans.WeeklyLocationRoot;

import edu.ucla.library.libservices.hours.clients.WeeklyHoursClient;

import java.util.Date;

public class Tester
{
  public Tester()
  {
    super();
  }

  public static void main( String[] args )
  {
    WeeklyHoursClient client;
    WeeklyLocationRoot theLocation;

    client = new WeeklyHoursClient();
    client.setInstitutionID( 3244 );
    client.setLocationID( 1940 );
    client.setWeeksCount( 2 );
    
    System.out.println( "starting at " + new Date() );
    theLocation = client.getTheLocation();
    System.out.println( "ending at " + new Date() );
    for ( WeeklyLocation locale : theLocation.getLocations() )
    {
      System.out.println( "name = " + locale.getName() + "\n\tID = " +
                          locale.getLocationID() + "\ttype = " +
                          locale.getCategory() );
      System.out.println( "\n\tweek count = " + locale.getWeeks().size() );
      System.out.println( "" );
    }
    /*for ( Unit locale: theLocation.getUnits() )
    {
      System.out.println( "name = " + locale.getName() + "\n\tID = " +
                          locale.getLocationID() + "\ttype = " +
                          locale.getCategory() );
      for ( Hour theHour: locale.getTimes().getHours() )
      {
        if ( theHour != null )
          System.out.println( "\n\tstart = " + theHour.getFrom() +
                              "\tend = " + theHour.getTo() );
      }
    }*/
  }
}
