package edu.ucla.library.libservices.hours.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@XmlAccessorType( XmlAccessType.FIELD )
public class Time
{
  final static Logger logger = LogManager.getLogger( Time.class );

  @XmlElement( name = "currently_open", nillable = true )
  private boolean currentlyOpen;
  @XmlElement( name = "status" )
  private String status;
  @XmlElement( name = "text", nillable = true )
  private String text;
  @XmlElement( name = "hours", nillable = true )
  private List<Hour> hours;
  private String date;

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
}
