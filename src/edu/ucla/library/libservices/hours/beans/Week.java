package edu.ucla.library.libservices.hours.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType( XmlAccessType.FIELD )
//@XmlElement(name = "week")
public class Week
{
  @XmlElement(name = "Sunday")
  private Sunday sun;
  @XmlElement(name = "Monday")
  private Monday mon;
  @XmlElement(name = "Tuesday")
  private Tuesday tues;
  @XmlElement(name = "Wednesday")
  private Wednesday weds;
  @XmlElement(name = "Thursday")
  private Thursday thurs;
  @XmlElement(name = "Friday")
  private Friday fri;
  @XmlElement(name = "Saturday")
  private Saturday sat;

  public Week()
  {
    super();
  }

  public void setSun( Sunday sun )
  {
    this.sun = sun;
  }

  public Sunday getSun()
  {
    return sun;
  }

  public void setMon( Monday mon )
  {
    this.mon = mon;
  }

  public Monday getMon()
  {
    return mon;
  }

  public void setTues( Tuesday tues )
  {
    this.tues = tues;
  }

  public Tuesday getTues()
  {
    return tues;
  }

  public void setWeds( Wednesday weds )
  {
    this.weds = weds;
  }

  public Wednesday getWeds()
  {
    return weds;
  }

  public void setThurs( Thursday thurs )
  {
    this.thurs = thurs;
  }

  public Thursday getThurs()
  {
    return thurs;
  }

  public void setFri( Friday fri )
  {
    this.fri = fri;
  }

  public Friday getFri()
  {
    return fri;
  }

  public void setSat( Saturday sat )
  {
    this.sat = sat;
  }

  public Saturday getSat()
  {
    return sat;
  }
}
