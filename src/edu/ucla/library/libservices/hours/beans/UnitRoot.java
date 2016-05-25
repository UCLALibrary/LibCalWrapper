package edu.ucla.library.libservices.hours.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType( XmlAccessType.FIELD )
@XmlRootElement( name="libcal" )
public class UnitRoot
{
  @XmlElement(name = "locations")
  private Unit[] units;
  
  public UnitRoot()
  {
    super();
  }

  public void setUnits( Unit[] units )
  {
    this.units = units;
  }

  public Unit[] getUnits()
  {
    return units;
  }
}
