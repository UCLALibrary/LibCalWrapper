package edu.ucla.library.libservices.hours.services;

import edu.ucla.library.libservices.hours.beans.DailyLocationRoot;
import edu.ucla.library.libservices.hours.beans.WeeklyLocation;
import edu.ucla.library.libservices.hours.beans.WeeklyLocationRoot;
import edu.ucla.library.libservices.hours.clients.DailyHoursClient;
import edu.ucla.library.libservices.hours.clients.WeeklyLocationClient;

import edu.ucla.library.libservices.hours.exceptions.LibCalException;

import java.util.List;

import java.util.stream.Collectors;

import javax.servlet.ServletConfig;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "/hours")
@Path("/hours")
public class HoursService
{
  @Context
  ServletConfig config;

  public HoursService()
  {
    super();
  }

  @GET
  @Produces("application/json")
  @Path("/today/{unitID}")
  @ApiOperation(value = "Finds operating hours for current day for particular Library unit",
                notes = "Valid unitID values are pulled from /units service", response = Response.class,
                httpMethod = "GET", produces = "application/json")
  public Response getUnits(@ApiParam(value = "unit(s) to be retrieved", required = true) @PathParam("unitID")
                           int unitID)
  {
    DailyHoursClient docMaker;
    DailyLocationRoot root;

    docMaker = new DailyHoursClient();
    //docMaker.setInstitutionID( 3244 );
    docMaker.setInstitutionID(Integer.parseInt(config.getServletContext().getInitParameter("iid.ucla")));
    docMaker.setLocationID(unitID);

    try
    {
      root = docMaker.getTheLocation();
      if (root.getLocations().size() == 0)
      {
        return Response.status(Response.Status.BAD_GATEWAY).build();
      }
      else
      {
        return Response.ok(root).build();
      }
    }
    catch (LibCalException lce)
    {
      return Response.status(Response.Status.fromStatusCode(Integer.parseInt(lce.getMessage()))).build();
    }
    catch (Exception e)
    {
      return Response.serverError().build();
    }
  }

  @GET
  @Produces("application/json")
  @Path("/weekly/{unitID}/weeks/{weekCount}")
  @SuppressWarnings("oracle.jdeveloper.webservice.rest.broken-resource-warning")
  @ApiOperation(value = "Finds operating hours for weekCount weeks for particular Library unit, or all units",
                notes = "Valid unitID values are pulled from /units service, or 0 for all units",
                response = Response.class, httpMethod = "GET", produces = "application/json")
  public Response getWeeks(@ApiParam(value = "unit(s) to be retrieved, 0 for all units", required = true)
                           @PathParam("unitID") int unitID,
                           @ApiParam(value = "number of weeks to be retrieved", required = true) @PathParam("weekCount")
                           int weekCount)
  {
    WeeklyLocationClient docMaker;
    WeeklyLocationRoot allUnits;
    WeeklyLocationRoot theUnit;

    docMaker = new WeeklyLocationClient();
    docMaker.setInstitutionID(Integer.parseInt(config.getServletContext().getInitParameter("iid.ucla")));
    System.out.println("received unit ID param " + unitID);
    docMaker.setLocationID(unitID);
    docMaker.setWeeksCount(weekCount);

    allUnits = docMaker.getTheLocation();
    //if ( unitID == 0 )
    if (unitID == Integer.parseInt(config.getServletContext().getInitParameter("units.all")))
    {
      return Response.ok(allUnits).build();
    }
    else
    {
      theUnit = new WeeklyLocationRoot();
      theUnit.setLocations(getUnitTimes(allUnits, unitID));

      return Response.ok(theUnit).build();
    }
  }

  private List<WeeklyLocation> getUnitTimes(WeeklyLocationRoot allUnits, int unitID)
  {
    return allUnits.getLocations()
                   .stream()
                   .filter(b -> b.getLocationID() == unitID || b.getParentLocationID() == unitID)
                   .collect(Collectors.toList());
  }
}
