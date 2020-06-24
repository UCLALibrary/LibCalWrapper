package edu.ucla.library.libservices.hours.clients;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

import edu.ucla.library.libservices.hours.beans.UnitRoot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UnitsClient
{
  final static Logger logger = LogManager.getLogger( UnitsClient.class );

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
    try
    {
	    theUnits = response.readEntity( UnitRoot.class );
	}
	catch (Exception e)
	{
		logger.error( "error making units root: " + e.getMessage() );
		theUnits = null;
	}
    return theUnits;
  }
}
