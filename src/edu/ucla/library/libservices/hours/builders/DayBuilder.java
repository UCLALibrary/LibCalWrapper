package edu.ucla.library.libservices.hours.builders;

import edu.ucla.library.libservices.hours.beans.Friday;
import edu.ucla.library.libservices.hours.beans.Monday;
import edu.ucla.library.libservices.hours.beans.Saturday;
import edu.ucla.library.libservices.hours.beans.Sunday;
import edu.ucla.library.libservices.hours.beans.Thursday;
import edu.ucla.library.libservices.hours.beans.Tuesday;
import edu.ucla.library.libservices.hours.beans.Wednesday;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DayBuilder
{
  public DayBuilder()
  {
    super();
  }
  
  public static Sunday buildSunday( Node dayNode )
  {
    Sunday sunday;
    NodeList details;

    sunday = new Sunday();
    details = dayNode.getChildNodes();
    for ( int i = 0; i < details.getLength(); i++ )
    {
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "date" ) )
        sunday.setDate( details.item( i ).getTextContent().trim() );
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "rendered" ) )
        sunday.setRendered( details.item( i ).getTextContent().trim() );
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "times" ) )
        sunday.setTimes( TimeBuilder.buildTime( details.item( i ) ) );
      
    }
    return sunday;
  }
  
  public static Monday buildMonday( Node dayNode )
  {
    Monday monday;
    NodeList details;

    monday = new Monday();
    details = dayNode.getChildNodes();
    for ( int i = 0; i < details.getLength(); i++ )
    {
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "date" ) )
        monday.setDate( details.item( i ).getTextContent().trim() );
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "rendered" ) )
        monday.setRendered( details.item( i ).getTextContent().trim() );
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "times" ) )
        monday.setTimes( TimeBuilder.buildTime( details.item( i ) ) );
      
    }
    return monday;
  }
  
  public static Tuesday buildTuesday( Node dayNode )
  {
    Tuesday tuesday;
    NodeList details;

    tuesday = new Tuesday();
    details = dayNode.getChildNodes();
    for ( int i = 0; i < details.getLength(); i++ )
    {
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "date" ) )
        tuesday.setDate( details.item( i ).getTextContent().trim() );
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "rendered" ) )
        tuesday.setRendered( details.item( i ).getTextContent().trim() );
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "times" ) )
        tuesday.setTimes( TimeBuilder.buildTime( details.item( i ) ) );
      
    }
    return tuesday;
  }
  
  public static Wednesday buildWednesday( Node dayNode )
  {
    Wednesday wednesday;
    NodeList details;

    wednesday = new Wednesday();
    details = dayNode.getChildNodes();
    for ( int i = 0; i < details.getLength(); i++ )
    {
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "date" ) )
        wednesday.setDate( details.item( i ).getTextContent().trim() );
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "rendered" ) )
        wednesday.setRendered( details.item( i ).getTextContent().trim() );
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "times" ) )
        wednesday.setTimes( TimeBuilder.buildTime( details.item( i ) ) );
      
    }
    return wednesday;
  }
  
  public static Thursday buildThursday( Node dayNode )
  {
    Thursday thursday;
    NodeList details;

    thursday = new Thursday();
    details = dayNode.getChildNodes();
    for ( int i = 0; i < details.getLength(); i++ )
    {
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "date" ) )
        thursday.setDate( details.item( i ).getTextContent().trim() );
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "rendered" ) )
        thursday.setRendered( details.item( i ).getTextContent().trim() );
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "times" ) )
        thursday.setTimes( TimeBuilder.buildTime( details.item( i ) ) );
      
    }
    return thursday;
  }
  
  public static Friday buildFriday( Node dayNode )
  {
    Friday friday;
    NodeList details;

    friday = new Friday();
    details = dayNode.getChildNodes();
    for ( int i = 0; i < details.getLength(); i++ )
    {
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "date" ) )
        friday.setDate( details.item( i ).getTextContent().trim() );
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "rendered" ) )
        friday.setRendered( details.item( i ).getTextContent().trim() );
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "times" ) )
        friday.setTimes( TimeBuilder.buildTime( details.item( i ) ) );
      
    }
    return friday;
  }
  
  public static Saturday buildSaturday( Node dayNode )
  {
    Saturday saturday;
    NodeList details;

    saturday = new Saturday();
    details = dayNode.getChildNodes();
    for ( int i = 0; i < details.getLength(); i++ )
    {
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "date" ) )
        saturday.setDate( details.item( i ).getTextContent().trim() );
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "rendered" ) )
        saturday.setRendered( details.item( i ).getTextContent().trim() );
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "times" ) )
        saturday.setTimes( TimeBuilder.buildTime( details.item( i ) ) );
      
    }
    return saturday;
  }
}
