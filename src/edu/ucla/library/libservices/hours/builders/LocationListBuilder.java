package edu.ucla.library.libservices.hours.builders;

import edu.ucla.library.libservices.hours.beans.WeeklyLocation;

import java.io.IOException;

import java.net.URL;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.TreeWalker;

import org.xml.sax.SAXException;

//import org.apache.logging.log4j.core.Logger;

public class LocationListBuilder
{
  //final static Logger logger = Logger.getLogger( LocationListBuilder.class );

  public LocationListBuilder()
  {
    super();
  }

  public static List<WeeklyLocation> buildLocations( String urlString )
  {
    Document source;
    DocumentTraversal traversal;
    List<WeeklyLocation> locations;
    Node theNode;
    TreeWalker walker;

    try
    {
      locations = new ArrayList<WeeklyLocation>();
      source =
        DocumentBuilderFactory.newInstance().newDocumentBuilder().parse( new URL( urlString ).openConnection().getInputStream() );
      if ( source.getImplementation().hasFeature( "Traversal", "2.0" ) )
      {
        traversal = ( DocumentTraversal ) source;
        walker = traversal.createTreeWalker( source.getDocumentElement(), NodeFilter.SHOW_ALL, null, false );
        theNode = walker.nextNode();
        while ( theNode != null )
        {
          if ( theNode.getNodeName().startsWith( "loc_" ) )
            locations.add( LocationBuilder.buildWeeklyLocation( theNode ) );
          theNode = walker.nextNode();
        }
      }
      return locations;
    }
    catch ( ParserConfigurationException pce )
    {
      //logger.error( "parser error: " + pce.getMessage(), pce );
      return new ArrayList<WeeklyLocation>();
    }
    catch ( IOException | SAXException e )
    {
      //logger.error( "parser error: " + e.getMessage(), e );
      return new ArrayList<WeeklyLocation>();
    }
  }
}
