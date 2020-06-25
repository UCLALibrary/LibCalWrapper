package edu.ucla.library.libservices.hours.clients;

import edu.ucla.library.libservices.hours.beans.Time;
import edu.ucla.library.libservices.hours.beans.Week;
//import edu.ucla.library.libservices.hours.beans.WeeklyLocation;
import edu.ucla.library.libservices.hours.beans.WeeklyLocationRoot;

import edu.ucla.library.libservices.hours.builders.LocationListBuilder;
import edu.ucla.library.libservices.hours.utility.EmptyChecker;

import edu.ucla.library.libservices.hours.utility.OpenChecker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WeeklyLocationClient
{
  final static Logger logger = LogManager.getLogger( WeeklyLocationClient.class );
  final static private String URL_BASE = "https://api3.libcal.com/api_hours_grid.php?iid=";
  final static private String JSON_TAIL = "&format=json";
  final static private String XML_TAIL = "&format=xml";

  private int institutionID;
  private int locationID;
  private int weeksCount;
  private WeeklyLocationRoot theLocation;

  public WeeklyLocationClient()
  {
    super();
  }

  public void setInstitutionID(int institutionID)
  {
    this.institutionID = institutionID;
  }

  private int getInstitutionID()
  {
    return institutionID;
  }

  public void setLocationID(int locationID)
  {
    this.locationID = locationID;
  }

  private int getLocationID()
  {
    return locationID;
  }

  public WeeklyLocationRoot getTheLocation()
  {
    Client client;
    Invocation.Builder invocationBuilder;
    Response response;
    String jsonString;
    String xmlString;
    WebTarget webTarget;

    client = ClientBuilder.newClient();
    jsonString = new StringBuffer(URL_BASE).append(getInstitutionID())
                                           .append("&lid=")
                                           .append(getLocationID())
                                           .append("&weeks=")
                                           .append(getWeeksCount())
                                           .append(JSON_TAIL)
                                           .toString();

    webTarget = client.target(jsonString);
    invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
    response = invocationBuilder.get();

    try
    {
      theLocation = response.readEntity(WeeklyLocationRoot.class);
    }
    catch (Exception e)
    {
      logger.error("error making units root: " + e.getMessage());
      theLocation = null;
    }

    if (theLocation != null && theLocation.getLocations() != null && !theLocation.getLocations().isEmpty())
      theLocation.getLocations()
                 .stream()
                 .forEach(l -> l.getWeeks()
                                .stream()
                                .forEach(w -> setOpen(w)));
    else
    {
      theLocation = new WeeklyLocationRoot();
      xmlString = new StringBuffer(URL_BASE).append(getInstitutionID())
                                            .append("&lid=")
                                            .append(getLocationID())
                                            .append("&weeks=")
                                            .append(getWeeksCount())
                                            .append(XML_TAIL)
                                            .toString();
      theLocation.setLocations(LocationListBuilder.buildLocations(xmlString));
      if (theLocation.getLocations() != null && !theLocation.getLocations().isEmpty())
        theLocation.getLocations()
                   .stream()
                   .forEach(l -> l.getWeeks()
                                  .stream()
                                  .forEach(w -> setOpen(w)));
    }
    return theLocation;
  }

  public void setWeeksCount(int weeksCount)
  {
    this.weeksCount = weeksCount;
  }

  private int getWeeksCount()
  {
    return weeksCount;
  }

  private void setOpen(Week theWeek)
  {
    theWeek.getSun()
           .getTimes()
           .setCurrentlyOpen(determinOpen(theWeek.getSun().getTimes()));
    theWeek.getMon()
           .getTimes()
           .setCurrentlyOpen(determinOpen(theWeek.getMon().getTimes()));
    theWeek.getTues()
           .getTimes()
           .setCurrentlyOpen(determinOpen(theWeek.getTues().getTimes()));
    theWeek.getWeds()
           .getTimes()
           .setCurrentlyOpen(determinOpen(theWeek.getWeds().getTimes()));
    theWeek.getThurs()
           .getTimes()
           .setCurrentlyOpen(determinOpen(theWeek.getThurs().getTimes()));
    theWeek.getFri()
           .getTimes()
           .setCurrentlyOpen(determinOpen(theWeek.getFri().getTimes()));
    theWeek.getSat()
           .getTimes()
           .setCurrentlyOpen(determinOpen(theWeek.getSat().getTimes()));
  }

  private boolean determinOpen(Time theTime)
  {
    String start;
    String end;
    start = new StringBuffer(theTime.getDate()).append(" ")
                                               .append(!EmptyChecker.isEmpty(theTime.getHours())? theTime.getHours()
                                                                                                         .get(0)
                                                                                                         .getFrom(): "")
                                               .toString();
    end = new StringBuffer(theTime.getDate()).append(" ")
                                             .append(!EmptyChecker.isEmpty(theTime.getHours())? theTime.getHours()
                                                                                                       .get(0)
                                                                                                       .getTo(): "")
                                             .toString();


    return OpenChecker.isLibraryOpen(start.toUpperCase(), end.toUpperCase(), theTime.getStatus());
  }
}
