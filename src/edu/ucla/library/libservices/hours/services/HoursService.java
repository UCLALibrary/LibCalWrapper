package edu.ucla.library.libservices.hours.services;

import edu.ucla.library.libservices.hours.clients.DailyHoursClient;

import edu.ucla.library.libservices.hours.clients.WeeklyHoursClient;

import javax.servlet.ServletConfig;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path( "/hours" )
public class HoursService
{
  @Context
  ServletConfig config;

  public HoursService()
  {
    super();
  }

  @GET
  @Produces( "application/json" )
  @Path( "/today/{unitID}" )
  public Response getUnits(@PathParam( "unitID" )
    int unitID)
  {
    DailyHoursClient docMaker;

    docMaker = new DailyHoursClient();
    docMaker.setInstitutionID( Integer.parseInt( config.getServletContext().getInitParameter( "iid.ucla" ) ) );
    docMaker.setLocationID( unitID );

    return Response.ok( docMaker.getTheLocation() ).build();
  }

  @GET
  @Produces( "application/json" )
  @Path( "/weekly/{unitID}/weeks/{weekCount}" )
  public Response getWeeks(@PathParam( "unitID" )
    int unitID, @PathParam( "weekCount" )
    int weekCount)
  {
    WeeklyHoursClient docMaker;

    docMaker = new WeeklyHoursClient();
    docMaker.setInstitutionID( Integer.parseInt( config.getServletContext().getInitParameter( "iid.ucla" ) ) );
    docMaker.setLocationID( unitID );
    docMaker.setWeeksCount( weekCount );

    return Response.ok( docMaker.getTheLocation() ).build();
  }
}
