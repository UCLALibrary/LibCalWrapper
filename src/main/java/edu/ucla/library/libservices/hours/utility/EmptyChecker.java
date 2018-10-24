package edu.ucla.library.libservices.hours.utility;

public class EmptyChecker
{
  public EmptyChecker()
  {
    super();
  }

  public static boolean isEmpty( String input )
  {
    return ( input == null || input.length() == 0 || input.equals( "" ) );
  }

  public static boolean isEmpty( Object input )
  {
    return ( input == null || input.toString().length() == 0 || input.toString().equals( "" ) );
  }
}
