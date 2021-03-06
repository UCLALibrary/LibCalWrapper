package edu.ucla.library.libservices.hours.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType( XmlAccessType.FIELD )
public class DayOfWeek
{
  @XmlElement(name = "times")
  private Time times;
  @XmlElement(name = "date")
  private String date;
  @XmlElement(name = "rendered")
  private String rendered;

  public DayOfWeek()
  {
    super();
  }

  public void setTimes( Time times )
  {
    this.times = times;
  }

  public Time getTimes()
  {
    times.setDate( getDate() );
    return times;
  }

  public void setDate( String date )
  {
    this.date = date;
  }

  public String getDate()
  {
    return date;
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
