package edu.ucla.library.libservices.hours.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType( XmlAccessType.FIELD )
public class WeeklyLocation
{
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

  public void setParentLocationID( int parentLocationID )
  {
    this.parentLocationID = parentLocationID;
  }

  public int getParentLocationID()
  {
    return parentLocationID;
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

  public void setWeeks( List<Week> weeks )
  {
    this.weeks = weeks;
  }

  public List<Week> getWeeks()
  {
    return weeks;
  }
  @XmlElement(name = "lid")
  private int locationID;
  @XmlElement(name = "name")
  private String name;
  @XmlElement(name = "category")
  private String category;
  @XmlElement(name = "parent_lid", nillable = true)
  private int parentLocationID;
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
  @XmlElement(name = "weeks")
  private List<Week> weeks;

  public WeeklyLocation()
  {
    super();
  }
}
