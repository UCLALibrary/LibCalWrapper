package edu.ucla.library.libservices.hours.builders;

import edu.ucla.library.libservices.hours.beans.Time;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TimeBuilder
{
  public TimeBuilder()
  {
    super();
  }

  public static Time buildTime( Node timeNode )
  {
    Time theTime;
    NodeList details;

    theTime = new Time();
    details = timeNode.getChildNodes();
    for ( int i = 0; i < details.getLength(); i++ )
    {
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "currently_open" ) )
        theTime.setCurrentlyOpen( Boolean.getBoolean( details.item( i ).getTextContent().trim() ) );
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "status" ) )
        theTime.setStatus( details.item( i ).getTextContent().trim() );
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "text" ) )
        theTime.setText( details.item( i ).getTextContent().trim() );
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "hours" ) )
        theTime.setHours( HourBuilder.buildHours(  details.item( i ) ) );
    }
    
    return theTime;
  }
}
