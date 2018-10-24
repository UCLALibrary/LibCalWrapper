package edu.ucla.library.libservices.hours.clients;

import edu.ucla.library.libservices.hours.beans.Time;
import edu.ucla.library.libservices.hours.beans.Week;
import edu.ucla.library.libservices.hours.beans.WeeklyLocation;
import edu.ucla.library.libservices.hours.beans.WeeklyLocationRoot;

import edu.ucla.library.libservices.hours.utility.EmptyChecker;

import edu.ucla.library.libservices.hours.utility.OpenChecker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

public class WeeklyLocationClient
{
  final static Logger logger = Logger.getLogger( WeeklyLocationClient.class );

  private int institutionID;
  private int locationID;
  private int weeksCount;
  private WeeklyLocationRoot theLocation;

  public WeeklyLocationClient()
  {
    super();
  }

  public void setInstitutionID( int institutionID )
  {
    this.institutionID = institutionID;
  }

  private int getInstitutionID()
  {
    return institutionID;
  }

  public void setLocationID( int locationID )
  {
    this.locationID = locationID;
  }

  private int getLocationID()
  {
    return locationID;
  }

  public WeeklyLocationRoot getTheLocation()
  {
    Client client;
    Invocation.Builder invocationBuilder;
    Response response;
    WebTarget webTarget;
    long start, end;

    start = System.currentTimeMillis();
    client = ClientBuilder.newClient();
    webTarget =
      client.target( "https://api3.libcal.com/api_hours_grid.php?iid=".concat( String.valueOf( getInstitutionID() ) ).concat( "&lid=" ).concat( String.valueOf( getLocationID() ) ).concat( "&weeks=" ).concat( String.valueOf( getWeeksCount() ) ).concat( "&format=json" ) );
    invocationBuilder = webTarget.request( MediaType.APPLICATION_JSON );
    response = invocationBuilder.get();
    theLocation = response.readEntity( WeeklyLocationRoot.class );
    end = System.currentTimeMillis();
    logger.debug( "libcal weekly hours retrieval took " + ( ( end - start ) / 1000L ) + " secs" );
    logger.debug( "libcal daily hours response is " + response.getStatus() );
    //setOpen( theLocation );
    theLocation.getLocations().stream().forEach( l -> l.getWeeks().stream().forEach( w -> setOpen( w ) ) );
    return theLocation;
  }

  public void setWeeksCount( int weeksCount )
  {
    this.weeksCount = weeksCount;
  }

  private int getWeeksCount()
  {
    return weeksCount;
  }
  private void setOpen( Week theWeek )
  {
    System.out.println( "in setOpen() method from streams" );
    theWeek.getSun().getTimes().setCurrentlyOpen( determinOpn( theWeek.getSun().getTimes() ) );
    theWeek.getMon().getTimes().setCurrentlyOpen( determinOpn( theWeek.getMon().getTimes() ) );
    theWeek.getTues().getTimes().setCurrentlyOpen( determinOpn( theWeek.getTues().getTimes() ) );
    theWeek.getWeds().getTimes().setCurrentlyOpen( determinOpn( theWeek.getWeds().getTimes() ) );
    theWeek.getThurs().getTimes().setCurrentlyOpen( determinOpn( theWeek.getThurs().getTimes() ) );
    theWeek.getFri().getTimes().setCurrentlyOpen( determinOpn( theWeek.getFri().getTimes() ) );
    theWeek.getSat().getTimes().setCurrentlyOpen( determinOpn( theWeek.getSat().getTimes() ) );
  }

  private void setOpen( WeeklyLocationRoot theLocale )
  {
    logger.debug( "in setOpen() method" );

    for ( WeeklyLocation weekly : theLocale.getLocations() )
    {
      for ( Week theWeek : weekly.getWeeks() )
      {
        theWeek.getSun().getTimes().setCurrentlyOpen( determinOpn( theWeek.getSun().getTimes() ) );
        theWeek.getMon().getTimes().setCurrentlyOpen( determinOpn( theWeek.getMon().getTimes() ) );
        theWeek.getTues().getTimes().setCurrentlyOpen( determinOpn( theWeek.getTues().getTimes() ) );
        theWeek.getWeds().getTimes().setCurrentlyOpen( determinOpn( theWeek.getWeds().getTimes() ) );
        theWeek.getThurs().getTimes().setCurrentlyOpen( determinOpn( theWeek.getThurs().getTimes() ) );
        theWeek.getFri().getTimes().setCurrentlyOpen( determinOpn( theWeek.getFri().getTimes() ) );
        theWeek.getSat().getTimes().setCurrentlyOpen( determinOpn( theWeek.getSat().getTimes() ) );
      }
    }
  }

  private boolean determinOpn( Time theTime )
  {
    String start;
    String end;

    start =
      new StringBuffer( theTime.getDate() ).append( " " ).append( !EmptyChecker.isEmpty( theTime.getHours() ) ?
                                                                  theTime.getHours().get( 0 ).getFrom() :
                                                                  "" ).toString();
    end =
      new StringBuffer( theTime.getDate() ).append( " " ).append( !EmptyChecker.isEmpty( theTime.getHours() ) ?
                                                                  theTime.getHours().get( 0 ).getTo() : "" ).toString();

    System.out.println( "calling OpenChecker with params " + start + ", " + end + ", " + theTime.getStatus() );
    logger.debug( "calling OpenChecker with params " + start + ", " + end + ", " + theTime.getStatus() );

    return OpenChecker.isLibraryOpen( start.toUpperCase(), end.toUpperCase(), theTime.getStatus() );
  }
}
