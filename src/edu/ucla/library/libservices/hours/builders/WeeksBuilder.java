package edu.ucla.library.libservices.hours.builders;

import edu.ucla.library.libservices.hours.beans.Week;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeeksBuilder
{
  public WeeksBuilder()
  {
    super();
  }

  public static List<Week> buildWeeks( Node startNode )
  {
    List<Week> theWeeks;
    NodeList weeksNodes;
    theWeeks = new ArrayList<Week>();
    weeksNodes = startNode.getChildNodes();
    for ( int i = 0; i < weeksNodes.getLength(); i++ )
    {
      if ( weeksNodes.item( i ).getNodeName().equalsIgnoreCase( "week" ) )
      {
        NodeList thisWeek;
        Week aWeek;
        aWeek = new Week();
        thisWeek = weeksNodes.item( i ).getChildNodes();
        for ( int j = 0; j < thisWeek.getLength(); j++ )
        {
          if ( thisWeek.item( j ).getNodeName().equalsIgnoreCase( "Sunday" ) )
          {
            aWeek.setSun( DayBuilder.buildSunday( thisWeek.item( j ) ) );
          }
          if ( thisWeek.item( j ).getNodeName().equalsIgnoreCase( "Monday" ) )
          {
            aWeek.setMon( DayBuilder.buildMonday( thisWeek.item( j ) ) );
          }
          if ( thisWeek.item( j ).getNodeName().equalsIgnoreCase( "Tuesday" ) )
          {
            aWeek.setTues( DayBuilder.buildTuesday( thisWeek.item( j ) ) );
          }
          if ( thisWeek.item( j ).getNodeName().equalsIgnoreCase( "Wednesday" ) )
          {
            aWeek.setWeds( DayBuilder.buildWednesday( thisWeek.item( j ) ) );
          }
          if ( thisWeek.item( j ).getNodeName().equalsIgnoreCase( "Thursday" ) )
          {
            aWeek.setThurs( DayBuilder.buildThursday( thisWeek.item( j ) ) );
          }
          if ( thisWeek.item( j ).getNodeName().equalsIgnoreCase( "Friday" ) )
          {
            aWeek.setFri( DayBuilder.buildFriday( thisWeek.item( j ) ) );
          }
          if ( thisWeek.item( j ).getNodeName().equalsIgnoreCase( "Saturday" ) )
          {
            aWeek.setSat( DayBuilder.buildSaturday( thisWeek.item( j ) ) );
          }
        }
        theWeeks.add( aWeek );
      }
    }
    return theWeeks;
  }
}
