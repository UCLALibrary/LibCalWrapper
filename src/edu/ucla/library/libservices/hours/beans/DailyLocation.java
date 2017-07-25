package edu.ucla.library.libservices.hours.beans;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType( XmlAccessType.FIELD )
public class DailyLocation
{
  static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");

  @XmlElement(name = "lid")
  private int locationID;
  @XmlElement(name = "name")
  private String name;
  @XmlElement(name = "category")
  private String category;
  @XmlElement(name = "day")
  private String day;
  @XmlElement(name = "desc")
  private String description;
  @XmlElement(name = "url")
  private String url;
  @XmlElement(name = "contact")
  private String contact;
  @XmlElement(name = "lat")
  private String latitude;
  @XmlElement(name = "long")
  private String longitude;
  @XmlElement(name = "color")
  private String color;
  @XmlElement(name = "times")
  private Time times;
  @XmlElement(name = "rendered")
  private String rendered;

  public DailyLocation()
  {
    super();
  }

  public void setLocationID( int locationID )
  {
    this.locationID = locationID;
  }

  public int getLocationID()
  {
    return locationID;
  }

  public void setName( String name )
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  public void setCategory( String category )
  {
    this.category = category;
  }

  public String getCategory()
  {
    return category;
  }

  public void setDay( String day )
  {
    this.day = day;
  }

  public String getDay()
  {
    return day;
  }

  public void setDescription( String description )
  {
    this.description = description;
  }

  public String getDescription()
  {
    return description;
  }

  public void setUrl( String url )
  {
    this.url = url;
  }

  public String getUrl()
  {
    return url;
  }

  public void setContact( String contact )
  {
    this.contact = contact;
  }

  public String getContact()
  {
    return contact;
  }

  public void setLatitude( String latitude )
  {
    this.latitude = latitude;
  }

  public String getLatitude()
  {
    return latitude;
  }

  public void setLongitude( String longitude )
  {
    this.longitude = longitude;
  }

  public String getLongitude()
  {
    return longitude;
  }

  public void setColor( String color )
  {
    this.color = color;
  }

  public String getColor()
  {
    return color;
  }

  public void setTimes( Time times )
  {
    this.times = times;
  }

  public Time getTimes()
  {
    times.setDate( FORMAT.format( new Date() ) );
    times.setLocationID( getLocationID() );
    return times;
  }

  public void setRendered( String rendered )
  {
    this.rendered = rendered;
  }

  public String getRendered()
  {
    return rendered;
  }
}
