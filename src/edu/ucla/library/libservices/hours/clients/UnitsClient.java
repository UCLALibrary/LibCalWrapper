package edu.ucla.library.libservices.hours.clients;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import edu.ucla.library.libservices.hours.beans.UnitRoot;

import javax.ws.rs.core.MediaType;

public class UnitsClient
{
  private Client client;
  private WebResource webResource;
  private int institutionID;
  private UnitRoot theUnits;

  public UnitsClient()
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

  public UnitRoot getTheUnits()
  {
    client = Client.create();
    webResource =
        client.resource( "https://api3.libcal.com/api_hours_today.php?iid=".concat( String.valueOf( getInstitutionID() ) ).concat( "&lid=0" ).concat( "&format=json" ) );
    theUnits =
        webResource.header( "charset", "utf-8" ).accept( MediaType.APPLICATION_XML,
                                                         MediaType.APPLICATION_JSON ).get( UnitRoot.class );
    return theUnits;
  }
}
