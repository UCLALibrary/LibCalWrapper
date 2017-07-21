package edu.ucla.library.libservices.hours.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType( XmlAccessType.FIELD )
@XmlRootElement( name = "libcal" )
public class UnitRoot
{
  @XmlElement( name = "locations" )
  private List<Unit> units;

  public void setUnits( List<Unit> units )
  {
    this.units = units;
  }

  public List<Unit> getUnits()
  {
    return units;
  }

  public UnitRoot()
  {
    super();
  }
}
