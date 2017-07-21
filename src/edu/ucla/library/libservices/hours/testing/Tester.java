package edu.ucla.library.libservices.hours.testing;

import edu.ucla.library.libservices.hours.beans.DailyLocationRoot;
import edu.ucla.library.libservices.hours.beans.WeeklyLocationRoot;
import edu.ucla.library.libservices.hours.services.HoursService;

import javax.ws.rs.core.Response;

public class Tester
{
  public Tester()
  {
    super();
  }

  public static void main( String[] args )
  {
    HoursService tester;
    Response response;
    //WeeklyLocationRoot theUnit;
    DailyLocationRoot theUnit;
    
    tester = new HoursService();
    response = tester.getUnits( 4707 );
    theUnit = ( DailyLocationRoot ) response.getEntity();
    System.out.println( "date = " +
    theUnit.getLocations().get( 0 ).getTimes().getDate() );
    System.out.println( "open status = " +
    theUnit.getLocations().get( 0 ).getTimes().isCurrentlyOpen() );
  }
}
