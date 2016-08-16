package edu.ucla.library.libservices.hours.clients;

//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import edu.ucla.library.libservices.hours.beans.UnitRoot;

//import javax.ws.rs.core.MediaType;

public class UnitsClient
{
  private Client client;
  private WebTarget webResource;
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
    client = ClientBuilder.newClient();
    webResource =
        client.target( "https://api3.libcal.com/api_hours_today.php?iid=".concat( String.valueOf( getInstitutionID() ) ).concat( "&lid=0" ).concat( "&format=json" ) );
    theUnits =
        webResource.request(MediaType.APPLICATION_JSON).get().readEntity( UnitRoot.class );
    return theUnits;
  }
}
