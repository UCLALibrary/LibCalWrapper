package edu.ucla.library.libservices.hours.beans;

//import edu.ucla.library.libservices.hours.clients.DailyHoursClient;
import edu.ucla.library.libservices.hours.utility.OpenChecker;

//import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import java.util.List;

import org.apache.log4j.Logger;

@XmlAccessorType( XmlAccessType.FIELD )
public class Time
{
  final static Logger logger = Logger.getLogger(Time.class);

  //@XmlElement( name = "currently_open", nillable = true )
  //private boolean currentlyOpen;
  @XmlElement( name = "status" )
  private String status;
  @XmlElement( name = "text", nillable = true )
  private String text;
  @XmlElement( name = "hours", nillable = true )
  private List<Hour> hours;
  private String date;
  @XmlElement( name = "calculatedOpen", nillable = true )
  @SuppressWarnings( "unused" )
  private boolean calculatedOpen;

  public Time()
  {
    super();
  }

  /*public void setCurrentlyOpen( boolean currentlyOpen )
  {
    this.currentlyOpen = currentlyOpen;
  }

  public boolean isCurrentlyOpen()
  {
    String start;
    String end;

    logger.info( "in isCurrentlyOpen() method" );
    System.out.println( "in isCurrentlyOpen() method" );

    start = new StringBuffer( getDate() ).append( " " ).append( getHours().get( 0 ).getFrom() ).toString();
    end = new StringBuffer( getDate() ).append( " " ).append( getHours().get( 0 ).getTo() ).toString();
    
    logger.info( "calling OpenChecker with params " + start + ", " + end + ", " + getStatus() );
    System.out.println( "calling OpenChecker with params " + start + ", " + end + ", " + getStatus() );

    return OpenChecker.isLibraryOpen( start.toUpperCase(), end.toUpperCase(), getStatus() );
  }*/

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

  /*public void setCalculatedOpen( boolean calculatedOpen )
  {
    this.calculatedOpen = calculatedOpen;
  }*/

  public boolean isCalculatedOpen()
  {
    String start;
    String end;

    logger.info( "in isCalculatedOpen() method" );
    System.out.println( "in isCalculatedOpen() method" );

    start = new StringBuffer( getDate() ).append( " " ).append( getHours().get( 0 ).getFrom() ).toString();
    end = new StringBuffer( getDate() ).append( " " ).append( getHours().get( 0 ).getTo() ).toString();
    
    logger.info( "calling OpenChecker from isCalculatedOpen with params " + start + ", " + end + ", " + getStatus() );
    System.out.println( "calling OpenChecker from isCalculatedOpen with params " + start + ", " + end + ", " + getStatus() );

    return OpenChecker.isLibraryOpen( start.toUpperCase(), end.toUpperCase(), getStatus() );
  }
}
