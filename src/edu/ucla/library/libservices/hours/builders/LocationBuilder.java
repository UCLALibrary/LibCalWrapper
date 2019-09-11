package edu.ucla.library.libservices.hours.builders;

import edu.ucla.library.libservices.hours.beans.WeeklyLocation;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LocationBuilder
{
  public LocationBuilder()
  {
    super();
  }
  
  public static WeeklyLocation buildWeeklyLocation( Node origin )
  {
    NodeList localeNodes;
    WeeklyLocation location;

    location = new WeeklyLocation();

    localeNodes = origin.getChildNodes();

    for ( int i = 0; i < localeNodes.getLength(); i++ )
    {
      if ( localeNodes.item( i ).getNodeName().equalsIgnoreCase( "lid" ) )
        location.setLocationID( Integer.parseInt( localeNodes.item( i ).getTextContent().trim() ) );
      if ( localeNodes.item( i ).getNodeName().equalsIgnoreCase( "name" ) )
        location.setName( localeNodes.item( i ).getTextContent().trim() );
      if ( localeNodes.item( i ).getNodeName().equalsIgnoreCase( "category" ) )
        location.setCategory( localeNodes.item( i ).getTextContent().trim() );
      if ( localeNodes.item( i ).getNodeName().equalsIgnoreCase( "parent_lid" ) )
        location.setParentLocationID( Integer.parseInt( localeNodes.item( i ).getTextContent().trim() ) );
      if ( localeNodes.item( i ).getNodeName().equalsIgnoreCase( "desc" ) )
        location.setDescription( localeNodes.item( i ).getTextContent().trim() );
      if ( localeNodes.item( i ).getNodeName().equalsIgnoreCase( "url" ) )
        location.setUrl( localeNodes.item( i ).getTextContent().trim() );
      if ( localeNodes.item( i ).getNodeName().equalsIgnoreCase( "contact" ) )
        location.setContact( localeNodes.item( i ).getTextContent().trim() );
      if ( localeNodes.item( i ).getNodeName().equalsIgnoreCase( "lat" ) )
        location.setLatitude( localeNodes.item( i ).getTextContent().trim() );
      if ( localeNodes.item( i ).getNodeName().equalsIgnoreCase( "long" ) )
        location.setLongitude( localeNodes.item( i ).getTextContent().trim() );
      if ( localeNodes.item( i ).getNodeName().equalsIgnoreCase( "color" ) )
        location.setColor( localeNodes.item( i ).getTextContent().trim() );
      if ( localeNodes.item( i ).getNodeName().equalsIgnoreCase( "weeks" ) )
        location.setWeeks( WeeksBuilder.buildWeeks( localeNodes.item( i ) ) );
    }

    return location;
  }
}
