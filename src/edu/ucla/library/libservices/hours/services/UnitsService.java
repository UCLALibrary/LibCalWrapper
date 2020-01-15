package edu.ucla.library.libservices.hours.services;

import edu.ucla.library.libservices.hours.beans.UnitRoot;
import edu.ucla.library.libservices.hours.clients.UnitsClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.servlet.ServletConfig;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "/units")
@Path("/units")
public class UnitsService
{
  @Context
  ServletConfig config;

  public UnitsService()
  {
    super();
  }

  @GET
  @Produces("application/json")
  @ApiOperation(value = "Retrieves list of Library units with schedules",
                notes = "Use unitIds from this service to get daily/weekly hours from /hours service",
                responseContainer = "Response", response = UnitRoot.class, httpMethod = "GET",
                produces = "application/json")
  public Response getUnits()
  {
    UnitsClient docMaker;

    docMaker = new UnitsClient();
    docMaker.setInstitutionID(Integer.parseInt(config.getServletContext().getInitParameter("iid.ucla")));

    return Response.ok(docMaker.getTheUnits()).build();
  }
}
