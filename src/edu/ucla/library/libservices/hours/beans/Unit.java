package edu.ucla.library.libservices.hours.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType( XmlAccessType.FIELD )
public class Unit
{
  @XmlElement( name = "lid" )
  private int locationID;
  @XmlElement( name = "name" )
  private String name;
  @XmlElement( name = "category" )
  private String category;

  public Unit()
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
}
