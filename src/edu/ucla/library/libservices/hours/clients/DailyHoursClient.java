package edu.ucla.library.libservices.hours.clients;

import edu.ucla.library.libservices.hours.beans.DailyLocation;
import edu.ucla.library.libservices.hours.beans.DailyLocationRoot;

import edu.ucla.library.libservices.hours.exceptions.LibCalException;
import edu.ucla.library.libservices.hours.utility.EmptyChecker;

import edu.ucla.library.libservices.hours.utility.OpenChecker;

import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DailyHoursClient
{
  private static final int OK = 200;

  final static Logger logger = LogManager.getLogger( DailyHoursClient.class );

  private int institutionID;
  private int locationID;
  private DailyLocationRoot theLocation;

  public DailyHoursClient()
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

  public DailyLocationRoot getTheLocation()
    throws LibCalException
  {
    Client client;
    Invocation.Builder invocationBuilder;
    Response response;
    WebTarget webTarget;
    //long start, end;

    //start = System.currentTimeMillis();
    client = ClientBuilder.newClient();
    webTarget =
      client.target( "https://api3.libcal.com/api_hours_today.php?iid=".concat( String.valueOf( getInstitutionID() ) ).concat( "&lid=" ).concat( String.valueOf( getLocationID() ) ).concat( "&format=json" ) );
    invocationBuilder = webTarget.request( MediaType.APPLICATION_JSON );
    response = invocationBuilder.get();

    try
    {
	    theLocation = response.readEntity( DailyLocationRoot.class );
	}
	catch (Exception e)
	{
		logger.error( "error making units root: " + e.getMessage() );
		theLocation = null;
	}

    if ( response.getStatus() != OK )
    {
      throw new LibCalException( String.valueOf( response.getStatus() ) );
    }

    if ( theLocation == null || theLocation.getLocations().size() == 0 )
    {
      throw new LibCalException( String.valueOf( Response.Status.BAD_GATEWAY.getStatusCode() ) );
    }

    if ( theLocation != null && theLocation.getLocations().size() > 0 )
    {
      theLocation.getLocations().stream().forEach( l -> setOpen( l ) );
	}
    return theLocation;
  }

  private void setOpen( DailyLocation daily )
  {
    String start;
    String end;

    //logger.debug( "in setOpen() method" );

    start =
      new StringBuffer( !EmptyChecker.isEmpty( daily.getTimes().getDate() ) ? daily.getTimes().getDate() :
                        new Date().toString() ).append( " " ).append( !EmptyChecker.isEmpty( daily.getTimes().getHours() ) ?
                                                                      daily.getTimes().getHours().get( 0 ).getFrom() :
                                                                      "" ).toString();
    end =
      new StringBuffer( !EmptyChecker.isEmpty( daily.getTimes().getDate() ) ? daily.getTimes().getDate() :
                        new Date().toString() ).append( " " ).append( !EmptyChecker.isEmpty( daily.getTimes().getHours() ) ?
                                                                      daily.getTimes().getHours().get( 0 ).getTo() :
                                                                      "" ).toString();
    //logger.debug( "calling OpenChecker with params " + start + ", " + end + ", " + daily.getTimes().getStatus() );

    daily.getTimes().setCurrentlyOpen( OpenChecker.isLibraryOpen( start.toUpperCase(), end.toUpperCase(),
                                                                  daily.getTimes().getStatus() ) );
  }
}
