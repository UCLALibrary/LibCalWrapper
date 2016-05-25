package edu.ucla.library.libservices.hours.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType( XmlAccessType.FIELD )
@XmlRootElement( name="libcal" )
public class WeeklyLocationRoot
{
  @XmlElement(name = "locations")
  private WeeklyLocation[] locations;

  public WeeklyLocationRoot()
  {
    super();
  }

  public void setLocations( WeeklyLocation[] locations )
  {
    this.locations = locations;
  }

  public WeeklyLocation[] getLocations()
  {
    return locations;
  }
}
