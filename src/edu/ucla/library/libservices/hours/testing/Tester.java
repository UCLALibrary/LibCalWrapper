package edu.ucla.library.libservices.hours.testing;

import edu.ucla.library.libservices.hours.beans.DailyLocation;
import edu.ucla.library.libservices.hours.beans.DailyLocationRoot;
import edu.ucla.library.libservices.hours.beans.WeeklyLocationRoot;
import edu.ucla.library.libservices.hours.services.HoursService;
import edu.ucla.library.libservices.hours.clients.WeeklyLocationClient;

import edu.ucla.library.libservices.hours.clients.XmlWeeklyLocationClient;
import edu.ucla.library.libservices.hours.services.StatusService;

import javax.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.time.format.DateTimeParseException;

public class Tester
{
  public Tester()
  {
    super();
  }

  public static void main( String[] args )
  {
    String combined;
    String date;
    String hours;

    date = "2019-09-11";
    hours = LocalDateTime.now().format( DateTimeFormatter.ofPattern( " ha" ) );
    combined = date.concat( hours );
    System.out.println( "combined hours = " + combined );
    System.out.println( "as LocalDateTime = " + LocalDateTime.parse(  combined,DateTimeFormatter.ofPattern( "yyyy-MM-dd ha" ) ) );
    /*WeeklyLocationClient client;
    WeeklyLocationRoot theLocation;
    long start, end;

    start = System.currentTimeMillis();
    client = new WeeklyLocationClient();
    client.setInstitutionID( 3244 );
    client.setLocationID( 6134 );
    client.setWeeksCount( 8 );

    theLocation = client.getTheLocation();
    System.out.println( "weekly results for " + theLocation.getLocations().get( 0 ).getName() + " places " );
    end = System.currentTimeMillis();
    System.out.println( "libcal weekly hours retrieval took " + ( ( end - start ) / 1000L ) + " secs" );*/
  }

  private static void output( DailyLocation daily )
  {
    System.out.println( "library = " + daily.getName() );
    System.out.println( "open status = " + daily.getTimes().isCurrentlyOpen() );
  }
}
