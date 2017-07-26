package edu.ucla.library.libservices.hours.services;

import edu.ucla.library.libservices.hours.beans.DailyLocationRoot;
import edu.ucla.library.libservices.hours.clients.DailyHoursClient;

import javax.servlet.ServletConfig;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path( "/status" )
public class StatusService
{
  @Context
  ServletConfig config;

  public StatusService()
  {
    super();
  }

  @GET
  @Produces( "text/plain" )
  @Path( "/today/{unitID}" )
  public Response getStatus( @PathParam( "unitID" ) int unitID )
  {
    DailyHoursClient docMaker;
    DailyLocationRoot theUnit;

    docMaker = new DailyHoursClient();
    //docMaker.setInstitutionID(3244);
    docMaker.setInstitutionID( Integer.parseInt( config.getServletContext().getInitParameter( "iid.ucla" ) ) );
    docMaker.setLocationID( unitID );

    theUnit = docMaker.getTheLocation();

    return Response.ok( theUnit.getLocations().get( 0 ).getTimes().isCurrentlyOpen() ).build();
  }
}
