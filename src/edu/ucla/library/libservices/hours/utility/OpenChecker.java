package edu.ucla.library.libservices.hours.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.time.format.DateTimeParseException;

//import org.apache.log4j.Logger;

public class OpenChecker
{
  //final static Logger logger = Logger.getLogger( OpenChecker.class );

  public OpenChecker()
  {
    super();
  }

  public static boolean isLibraryOpen( String fromDate, String toDate, String status )
  {
    LocalDateTime formattedStart;
    LocalDateTime formattedEnd;
    LocalDateTime today;

    //logger.debug( "in isLibraryOpen method" );
    //System.out.println( "in isLibraryOpen method" );
    if ( status.equalsIgnoreCase( "24hours" ) )
    {
      //logger.debug( "returning true due to 24hours status" );
      //System.out.println( "returning true due to 24hours status" );
      return true;
    }
    else if ( status.equalsIgnoreCase( "closed" ) || status.equalsIgnoreCase( "not-set" ) ||
              status.equalsIgnoreCase( "text" ) || status.equalsIgnoreCase( "ByApp" ) ||
              EmptyChecker.isEmpty( status ) )
    {
      //logger.debug( "returning false due to closed/unset/empty/appointment status" );
      //System.out.println( "returning false due to closed/unset/empty status" );
      return false;
    }
    else
    {
      formattedStart = parseDate( fromDate );
      formattedEnd = parseDate( toDate );
      today = LocalDateTime.now();
      //System.out.println( "current time = " + today );

      if ( formattedStart.isAfter( formattedEnd ) )
      {
        formattedEnd = formattedEnd.plusDays( 1 );
      }

      if ( ( today.isEqual( formattedStart ) || today.isAfter( formattedStart ) ) && today.isBefore( formattedEnd ) )
      {
        //logger.debug( "returning true due to current time between unit open/close" );
        //System.out.println( "returning true due to current time between unit open/close" );
        return true;
      }
      else
      {
        //logger.debug( "returning false due to current time outside unit open/close" );
        //System.out.println( "returning false due to current time outside unit open/close" );
        return false;
      }
    }
  }

  private static LocalDateTime parseDate( String timestamp )
  {
    DateTimeFormatter justDate;
    DateTimeFormatter justHour;
    DateTimeFormatter withMinutes;

    justDate = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );
    justHour = DateTimeFormatter.ofPattern( "yyyy-MM-dd ha" );
    withMinutes = DateTimeFormatter.ofPattern( "yyyy-MM-dd h:ma" );

    if ( timestamp.trim().length() == 10 )
    {
      try
      {
        String hours = LocalDateTime.now().format( DateTimeFormatter.ofPattern( " ha" ) );
        return LocalDateTime.parse( timestamp.trim(), justDate );
      }
      catch ( DateTimeParseException dtpe )
      {
        //logger.error( "time parse error, justDate: " + dtpe.getMessage() );
        return null;
      }
    }
    else if ( timestamp.trim().contains( ":" ) )
    {
      try
      {
        return LocalDateTime.parse( timestamp.trim(), withMinutes );
      }
      catch ( DateTimeParseException dtpe )
      {
        //logger.error( "time parse error, withMinutes: " + dtpe.getMessage() );
        return null;
      }
    }
    else
    {
      try
      {
        return LocalDateTime.parse( timestamp.trim(), justHour );
      }
      catch ( DateTimeParseException dtpe )
      {
        //logger.error( "time parse error,justHour: " + dtpe.getMessage() );
        return null;
      }
    }
  }
}
