package edu.ucla.library.libservices.hours.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import java.util.List;

@XmlAccessorType( XmlAccessType.FIELD )
public class Time
{
  @XmlElement( name = "currently_open", nillable = true )
  private boolean currentlyOpen;
  @XmlElement( name = "status" )
  private String status;
  @XmlElement( name = "text", nillable = true )
  private String text;
  @XmlElement( name = "hours", nillable = true )
  private List<Hour> hours;

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

  public void setHours( List<Hour> hours )
  {
    this.hours = hours;
  }

  public List<Hour> getHours()
  {
    return hours;
  }

  public void setText( String text )
  {
    this.text = text;
  }

  public String getText()
  {
    return text;
  }
}
