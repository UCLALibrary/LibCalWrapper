package edu.ucla.library.libservices.hours.exceptions;

public class LibCalException
  extends Exception
{
  @SuppressWarnings( "compatibility:8197379674193906392" )
  private static final long serialVersionUID = -5871723238249875673L;

  public LibCalException( String string, Throwable throwable, boolean b, boolean b1 )
  {
    super( string, throwable, b, b1 );
  }

  public LibCalException( Throwable throwable )
  {
    super( throwable );
  }

  public LibCalException( String string, Throwable throwable )
  {
    super( string, throwable );
  }

  public LibCalException( String string )
  {
    super( string );
  }

  public LibCalException()
  {
    super();
  }
}
