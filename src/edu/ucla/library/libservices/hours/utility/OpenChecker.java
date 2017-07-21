package edu.ucla.library.libservices.hours.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OpenChecker
{
  public OpenChecker()
  {
    super();
  }

  public static boolean isLibraryOpen( String fromDate, String toDate, String status )
  {
    LocalDateTime formattedStart;
    LocalDateTime formattedEnd;
    LocalDateTime today;

    if ( status.equalsIgnoreCase( "24hours" ) )
      return true;
    else if ( status.equalsIgnoreCase( "closed" ) || status.equalsIgnoreCase( "not-set" ) || isEmpty( status ) )
      return false;
    else
    {
      formattedStart = parseDate( fromDate );
      formattedEnd = parseDate( toDate );
      today = LocalDateTime.now();

      if ( formattedStart.isAfter( formattedEnd ) )
      {
        formattedEnd = formattedEnd.plusDays( 1 );
      }

      if ( ( today.isEqual( formattedStart ) || today.isAfter( formattedStart ) ) && today.isBefore( formattedEnd ) )
        return true;
      else
        return false;
    }
  }

  private static LocalDateTime parseDate( String timestamp )
  {
    DateTimeFormatter justHour;
    DateTimeFormatter withMinutes;

    justHour = DateTimeFormatter.ofPattern( "yyyy-MM-dd ha" );
    withMinutes = DateTimeFormatter.ofPattern( "yyyy-MM-dd h:ma" );

    if ( timestamp.contains( ":" ) )
      return LocalDateTime.parse( timestamp, withMinutes );
    else
      return LocalDateTime.parse( timestamp, justHour );
  }

  private static boolean isEmpty( String input )
  {
    return ( input.length() == 0 || input.equals( "" ) || input == null );
  }
}
