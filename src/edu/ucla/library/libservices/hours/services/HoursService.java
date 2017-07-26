package edu.ucla.library.libservices.hours.services;

import edu.ucla.library.libservices.hours.beans.WeeklyLocation;
import edu.ucla.library.libservices.hours.beans.WeeklyLocationRoot;
import edu.ucla.library.libservices.hours.clients.DailyHoursClient;
import edu.ucla.library.libservices.hours.clients.WeeklyLocationClient;

import java.util.List;

import java.util.stream.Collectors;

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
  public Response getUnits( @PathParam( "unitID" ) int unitID )
  {
    DailyHoursClient docMaker;

    docMaker = new DailyHoursClient();
    //docMaker.setInstitutionID(3244);
    docMaker.setInstitutionID( Integer.parseInt( config.getServletContext().getInitParameter( "iid.ucla" ) ) );
    docMaker.setLocationID( unitID );

    return Response.ok( docMaker.getTheLocation() ).build();
  }

  @GET
  @Produces("application/json")
  @Path("/weekly/{unitID}/weeks/{weekCount}")
  @SuppressWarnings( "oracle.jdeveloper.webservice.rest.broken-resource-warning" )
  public Response getWeeks(@PathParam("unitID") int unitID, @PathParam("weekCount") int weekCount) {
      WeeklyLocationClient docMaker;
      WeeklyLocationRoot allUnits;
      WeeklyLocationRoot theUnit;

      docMaker = new WeeklyLocationClient();
      //docMaker.setInstitutionID(3244);
      docMaker.setInstitutionID(Integer.parseInt(config.getServletContext().getInitParameter("iid.ucla")));
      //docMaker.setLocationID(0);
      docMaker.setLocationID(Integer.parseInt(config.getServletContext().getInitParameter("units.all")));
      docMaker.setWeeksCount(weekCount);

      allUnits = docMaker.getTheLocation();
      if ( unitID == 0 )
      //if ( unitID == Integer.parseInt(config.getServletContext().getInitParameter("units.all")) )
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

  private List<WeeklyLocation> getUnitTimes(WeeklyLocationRoot allUnits, int unitID) {
      return allUnits.getLocations().stream().filter(b -> b.getLocationID() == unitID ||
                                                     b.getParentLocationID() == unitID).collect(Collectors.toList());
  }
}
