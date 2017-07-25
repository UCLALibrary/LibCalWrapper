package edu.ucla.library.libservices.hours.testing;

import edu.ucla.library.libservices.hours.beans.DailyLocationRoot;
import edu.ucla.library.libservices.hours.beans.WeeklyLocationRoot;
import edu.ucla.library.libservices.hours.services.HoursService;

import edu.ucla.library.libservices.hours.services.StatusService;

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
    //response = tester.getWeeks( 4707, 1 );
    response = tester.getUnits( 4707 );
    //theUnit = ( WeeklyLocationRoot ) response.getEntity();
    theUnit = ( DailyLocationRoot ) response.getEntity();
    //System.out.println( "date = " +
    //theUnit.getLocations().get( 0 ).getWeeks().get( 0 ).getFri().getTimes().getDate() );
    System.out.println( "date = " +
    theUnit.getLocations().get( 0 ).getTimes().getDate() );
    //System.out.println( "open status = " +
    //theUnit.getLocations().get( 0 ).getWeeks().get( 0 ).getFri().getTimes().isCurrentlyOpen() );
    System.out.println( "library = " +
    theUnit.getLocations().get( 0 ).getName() );
    System.out.println( "open status = " +
    theUnit.getLocations().get( 0 ).getTimes().isCurrentlyOpen() );
    
    /*Response response;
    StatusService status;
    status = new StatusService();
    response = status.getStatus( 2082 );
    System.out.println( "status from new service = " + response.getEntity() );*/
  }
}
