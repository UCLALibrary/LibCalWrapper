package edu.ucla.library.libservices.hours.clients;

import edu.ucla.library.libservices.hours.beans.DailyLocationRoot;
import edu.ucla.library.libservices.hours.beans.WeeklyLocationRoot;

import java.io.File;
import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;

import org.w3c.dom.Document;

import org.xml.sax.SAXException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import javax.xml.bind.util.JAXBResult;

public class XmlWeeklyLocationClient
{
  //final static private String URL_BASE = "https://api3.libcal.com/api_hours_grid.php?iid=";
  final static private String URL_BASE = "https://api3.libcal.com/api_hours_today.php?iid=";
  final static private String URL_TAIL = "&format=xml";
  final static Logger logger = Logger.getLogger( WeeklyLocationClient.class );

  private int institutionID;
  private int locationID;
  private int weeksCount;
  private WeeklyLocationRoot theLocation;
  private DailyLocationRoot daily;

  public XmlWeeklyLocationClient()
  {
    super();
  }

  public void setInstitutionID( int institutionID )
  {
    this.institutionID = institutionID;
  }

  private int getInstitutionID()
  {
    return institutionID;
  }

  public void setLocationID( int locationID )
  {
    this.locationID = locationID;
  }

  private int getLocationID()
  {
    return locationID;
  }

  public void setWeeksCount( int weeksCount )
  {
    this.weeksCount = weeksCount;
  }

  private int getWeeksCount()
  {
    return weeksCount;
  }

  public WeeklyLocationRoot getTheLocation()
  {
    Document doc;
    Document transformed;
    String urlString;
    TransformerFactory tFactory;
    StreamSource stylesource;
    Transformer transformer;
    DOMSource source;
    //DOMResult result;
    //JAXBResult result;
    StreamResult result;
    JAXBContext jaxbContext;
    Unmarshaller jaxbUnmarshaller;

    urlString = new StringBuffer( URL_BASE ).append( getInstitutionID() ).append( "&lid=" ).append( getLocationID() ).append( "&weeks=" ).append( getWeeksCount() ).append( URL_TAIL ).toString();
    System.out.println( "calling " + urlString );
    logger.debug( "calling " + urlString );

    try
    {
      doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse( new URL( urlString ).openConnection().getInputStream() );
      tFactory = TransformerFactory.newInstance();
      stylesource = new StreamSource( new File("H:\\mywork\\AltCalendar\\public_html\\styles\\backwards.xsl") );
      transformer = tFactory.newTransformer( stylesource );
      source = new DOMSource( doc );
      result = new StreamResult( System.out );
      //result = new JAXBResult( JAXBContext.newInstance(WeeklyLocationRoot.class) );
      transformer.transform(source, result);
      //transformed = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse( result );
      //jaxbContext = JAXBContext.newInstance(WeeklyLocationRoot.class);
      //jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      //theLocation = (WeeklyLocationRoot) jaxbUnmarshaller.unmarshal( result );
      //theLocation = ( WeeklyLocationRoot ) result.getResult();
    }
    catch ( MalformedURLException mue )
    {
      logger.error( "bad URL error: ", mue );
    }
    catch ( IOException ioe )
    {
      logger.error( "I/O error: ", ioe );
    }
    catch ( ParserConfigurationException pce )
    {
      logger.error( "Parsing error: ", pce );
    }
    catch ( SAXException saxe )
    {
      logger.error( "SAX error: ", saxe );
    }
    catch ( TransformerConfigurationException tce )
    {
      logger.error( "Transform config error: ", tce );
    }
    catch ( TransformerException te )
    {
      logger.error( "Transform error: ", te );
    }
    /*catch ( JAXBException jaxbe )
    {
      logger.error( "JAXB error: ", jaxbe );
    }*/

    return theLocation;
  }


  public DailyLocationRoot getDaily()
  {
    Document doc;
    String urlString;
    StreamSource stylesource;
    Transformer transformer;
    DOMSource source;
    JAXBResult result;
    JAXBContext jaxbContext;
    Unmarshaller jaxbUnmarshaller;

    urlString = new StringBuffer( URL_BASE ).append( getInstitutionID() ).append( "&lid=" ).append( getLocationID() ).append( "&weeks=" ).append( getWeeksCount() ).append( URL_TAIL ).toString();
    System.out.println( "calling " + urlString );

    try
    {
      doc =
        DocumentBuilderFactory.newInstance().newDocumentBuilder().parse( new URL( urlString ).openConnection().getInputStream() );
      stylesource = new StreamSource( new File("H:\\mywork\\AltCalendar\\public_html\\styles\\backwards.xsl") );
      transformer = TransformerFactory.newInstance().newTransformer( stylesource );
      source = new DOMSource( doc );
      result = new JAXBResult( JAXBContext.newInstance(DailyLocationRoot.class) );
      transformer.transform(source, result);
      daily = ( DailyLocationRoot ) result.getResult();

      return daily;
    }
    catch ( ParserConfigurationException pce )
    {
      pce.printStackTrace();
      return null;
    }
    catch ( IOException | SAXException e )
    {
      e.printStackTrace();
      return null;
    }
    catch ( TransformerConfigurationException tce )
    {
      tce.printStackTrace();
      return null;
    }
    catch ( JAXBException je )
    {
      je.printStackTrace();
      return null;
    }
    catch ( TransformerException te )
    {
      te.printStackTrace();
      return null;
    }
  }
}
