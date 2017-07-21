package edu.ucla.library.libservices.hours.beans;

import edu.ucla.library.libservices.hours.utility.OpenChecker;

import java.util.GregorianCalendar;

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
    String start;
    String end;

    start = new StringBuffer( getDate() ).append( " " ).append( getHours().get( 0 ).getFrom() ).toString();
    end = new StringBuffer( getDate() ).append( " " ).append( getHours().get( 0 ).getTo() ).toString();

    return OpenChecker.isLibraryOpen( start.toUpperCase(), end.toUpperCase(), getStatus() );
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
