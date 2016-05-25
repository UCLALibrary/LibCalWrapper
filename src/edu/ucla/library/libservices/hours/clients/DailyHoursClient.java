package edu.ucla.library.libservices.hours.clients;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import edu.ucla.library.libservices.hours.beans.DailyLocationRoot;

import javax.ws.rs.core.MediaType;

public class DailyHoursClient
{
  private Client client;
  private WebResource webResource;
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
  {
    client = Client.create();
    webResource =
        client.resource( "https://api3.libcal.com/api_hours_today.php?iid=".concat( String.valueOf( getInstitutionID() ) ).concat( "&lid=" ).concat( String.valueOf( getLocationID() ) ).concat( "&format=json" ) );
    System.out.println( webResource.getURI().getHost() + "/" +
                        webResource.getURI().getPath() + "?" +
                        webResource.getURI().getQuery() );
    theLocation =
        webResource.header( "charset", "utf-8" ).accept( MediaType.APPLICATION_XML,
                                                         MediaType.APPLICATION_JSON ).get( DailyLocationRoot.class );
    return theLocation;
  }
}
