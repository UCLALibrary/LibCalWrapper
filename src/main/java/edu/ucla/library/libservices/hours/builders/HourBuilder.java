package edu.ucla.library.libservices.hours.builders;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import edu.ucla.library.libservices.hours.beans.Hour;

public class HourBuilder
{
  public HourBuilder()
  {
    super();
  }
  
  public static List<Hour> buildHours( Node hoursNode )
  {
    List<Hour> hours;
    NodeList details;

    hours = new ArrayList<Hour>();
    details = hoursNode.getChildNodes();
    for ( int i = 0; i < details.getLength(); i++ )
    {
      if ( details.item( i ).getNodeName().equalsIgnoreCase( "hour" ) )
      {
        Hour anHour;
        NodeList times;
        anHour = new Hour();
        times = details.item( i ).getChildNodes();
        for ( int j = 0; j < times.getLength(); j++ )
        {
          if ( times.item( j ).getNodeName().equalsIgnoreCase( "from" ) )
            anHour.setFrom( times.item( j ).getTextContent().trim() );
          if ( times.item( j ).getNodeName().equalsIgnoreCase( "to" ) )
            anHour.setTo( times.item( j ).getTextContent().trim() );
        }
        hours.add( anHour );
      }
    }
    return hours;
  }
}
