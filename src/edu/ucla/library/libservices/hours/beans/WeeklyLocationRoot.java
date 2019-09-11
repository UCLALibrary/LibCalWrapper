package edu.ucla.library.libservices.hours.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType( XmlAccessType.FIELD )
@XmlRootElement( name="libcal" )
public class WeeklyLocationRoot
{
  @XmlElement(name = "locations")
  private List<WeeklyLocation> locations;

  public WeeklyLocationRoot()
  {
    super();
  }

  public void setLocations( List<WeeklyLocation> locations )
  {
    this.locations = locations;
  }

  public List<WeeklyLocation> getLocations()
  {
    return locations;
  }
}
