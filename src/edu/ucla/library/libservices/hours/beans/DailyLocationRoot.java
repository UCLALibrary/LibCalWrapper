package edu.ucla.library.libservices.hours.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType( XmlAccessType.FIELD )
@XmlRootElement( name="libcal" )
public class DailyLocationRoot
{
  @XmlElement(name = "locations")
  private DailyLocation[] locations;
  
  public DailyLocationRoot()
  {
    super();
  }

  public DailyLocation[] getLocations()
  {
    return locations;
  }

  public void setLocations( DailyLocation[] locations )
  {
    this.locations = locations;
  }
}
