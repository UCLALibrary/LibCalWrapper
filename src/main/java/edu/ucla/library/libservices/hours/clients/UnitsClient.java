package edu.ucla.library.libservices.hours.clients;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

import edu.ucla.library.libservices.hours.beans.UnitRoot;

public class UnitsClient
{
  private int      institutionID;
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

  public void setTheUnits( UnitRoot theUnits )
  {
    this.theUnits = theUnits;
  }

  public UnitRoot getTheUnits()
  {
    Client             client;
    Invocation.Builder invocationBuilder;
    Response           response;
    WebTarget          webTarget;

    client = ClientBuilder.newClient();
    webTarget =
      client.target( "https://api3.libcal.com/api_hours_today.php?iid=".concat( String.valueOf( getInstitutionID() ) ).concat( "&lid=0&format=json" ) );
    invocationBuilder = webTarget.request( MediaType.APPLICATION_JSON );
    response = invocationBuilder.get();
    theUnits = response.readEntity( UnitRoot.class );
    return theUnits;
  }
}
