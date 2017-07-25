package edu.ucla.library.libservices.hours.beans;

import edu.ucla.library.libservices.hours.services.StatusService;
import edu.ucla.library.libservices.hours.utility.EmptyChecker;
import edu.ucla.library.libservices.hours.utility.OpenChecker;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

@XmlAccessorType( XmlAccessType.FIELD )
public class Time
{
  final static Logger logger = Logger.getLogger( Time.class );

  @XmlElement( name = "currently_open", nillable = true )
  private boolean currentlyOpen;
  @XmlElement( name = "status" )
  private String status;
  @XmlElement( name = "text", nillable = true )
  private String text;
  @XmlElement( name = "hours", nillable = true )
  private List<Hour> hours;
  private String date;
  @XmlElement( name = "newField", nillable = true )
  private boolean newField;
  private int locationID;

  public Time()
  {
    super();
  }

  public void setCurrentlyOpen( boolean currentlyOpen )
  {
    this.currentlyOpen = currentlyOpen;
  }

  public boolean isCurrentlyOpen()
  {
    return currentlyOpen;
  }

  public void setStatus( String status )
  {
    this.status = status;
  }

  public String getStatus()
  {
    return status;
  }

  public void setText( String text )
  {
    this.text = text;
  }

  public String getText()
  {
    return text;
  }

  public void setHours( List<Hour> hours )
  {
    this.hours = hours;
  }

  public List<Hour> getHours()
  {
    return hours;
  }

  public void setDate( String date )
  {
    this.date = date;
  }

  public String getDate()
  {
    return date;
  }

  public void setNewField( boolean newField )
  {
    this.newField = newField;
  }

  public boolean isNewField()
  {
    return true;
  }

  public void setLocationID( int locationID )
  {
    this.locationID = locationID;
  }

  public int getLocationID()
  {
    return locationID;
  }
}
