package edu.ucla.library.libservices.hours.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType( XmlAccessType.FIELD )
@XmlRootElement( name="libcal" )
public class DailyLocationRoot
{
  @XmlElement(name = "locations")
  private List<DailyLocation> locations;

  public void setLocations( List<DailyLocation> locations )
  {
    this.locations = locations;
  }

  public List<DailyLocation> getLocations()
  {
    return locations;
  }

  public DailyLocationRoot()
  {
    super();
  }
}
