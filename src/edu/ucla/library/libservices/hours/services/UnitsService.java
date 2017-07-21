package edu.ucla.library.libservices.hours.services;

import edu.ucla.library.libservices.hours.clients.UnitsClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.servlet.ServletConfig;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path( "/units" )
public class UnitsService
{
  @Context
  ServletConfig config;

  public UnitsService()
  {
    super();
  }

  @GET
  @Produces( "application/json" )
  public Response getUnits()
  {
    UnitsClient docMaker;

    docMaker = new UnitsClient();
    docMaker.setInstitutionID( Integer.parseInt( config.getServletContext().getInitParameter( "iid.ucla" ) ) );

    return Response.ok( docMaker.getTheUnits() ).build();
  }
}
