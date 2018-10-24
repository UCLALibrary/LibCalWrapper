package edu.ucla.library.libservices.hours.testing;

import edu.ucla.library.libservices.hours.beans.DailyLocation;
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
    /*for ( Response.Status theStatus : Response.Status.values() )
    {
      System.out.println( "status " + theStatus + " has value " + theStatus.getStatusCode() );
      //Response.Status.fromStatusCode( 300 );
      //Response.status(  );
    }*/
    HoursService tester;
    Response response;
    //WeeklyLocationRoot theUnit;
    DailyLocationRoot theUnit;

    tester = new HoursService();
    //response = tester.getWeeks( 4707, 1 );
    response = tester.getUnits( -1 );
    System.out.println( "return status = " + response.getStatus() );
    //theUnit = ( WeeklyLocationRoot ) response.getEntity();
    //theUnit = ( DailyLocationRoot ) response.getEntity();
    //System.out.println( "date = " + theUnit.getLocations().get( 0 ).getWeeks().get( 0 ).getFri().getTimes().getDate() );
    //System.out.println( "date = " + theUnit.getLocations().get( 0 ).getTimes().getDate() );
    //System.out.println( "open status = " + theUnit.getLocations().get( 0 ).getWeeks().get( 0 ).getFri().getTimes().isCurrentlyOpen() );
    //System.out.println( "library = " + theUnit.getLocations().get( 0 ).getName() );
    //System.out.println( "open status = " + theUnit.getLocations().get( 0 ).getTimes().isCurrentlyOpen() );
    //theUnit.getLocations().stream().forEach( l -> output( l ) );

    /*Response response;
    StatusService status;
    status = new StatusService();
    response = status.getStatus( 2082 );
    System.out.println( "status from new service = " + response.getEntity() );*/
  }

  private static void output( DailyLocation daily )
  {
    System.out.println( "library = " + daily.getName() );
    System.out.println( "open status = " + daily.getTimes().isCurrentlyOpen() );
  }
}
