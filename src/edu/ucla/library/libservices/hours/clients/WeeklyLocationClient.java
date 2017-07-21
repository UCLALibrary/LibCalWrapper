package edu.ucla.library.libservices.hours.clients;

import edu.ucla.library.libservices.hours.beans.WeeklyLocationRoot;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

public class WeeklyLocationClient
{
  final static Logger logger = Logger.getLogger(WeeklyLocationClient.class);

  private int                institutionID;
  private int                locationID;
  private int                weeksCount;
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
    Client             client;
    Invocation.Builder invocationBuilder;
    Response           response;
    WebTarget          webTarget;
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
    logger.debug("libcal daily hours response is " + response.getStatus());
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
}
