package edu.ucla.library.libservices.hours.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType( XmlAccessType.FIELD )
public class Hour
{
  @XmlElement(name = "from")
  private String from;
  @XmlElement(name = "to")
  private String to;
  
  public Hour()
  {
    super();
  }

  public void setFrom( String from )
  {
    this.from = from;
  }

  public String getFrom()
  {
    return from;
  }

  public void setTo( String to )
  {
    this.to = to;
  }

  public String getTo()
  {
    return to;
  }
}
