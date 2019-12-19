package edu.ucla.library.libservices.hours.servlets;

import io.swagger.jaxrs.config.BeanConfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class SwaggerBootstrap
  extends HttpServlet
{
  @SuppressWarnings("compatibility:-3022344279312105443")
  private static final long serialVersionUID = 4075689404757438826L;

  public void init(ServletConfig config)
    throws ServletException
  {
    super.init(config);

    BeanConfig beanConfig;

    beanConfig = new BeanConfig();
    beanConfig.setVersion( "2.0.0" );
    beanConfig.setSchemes( new String[] { "https" } );
    beanConfig.setHost( "webservices-test.library.ucla.edu" );
    beanConfig.setBasePath( "/calendar" );
    beanConfig.setResourcePackage( "edu.ucla.library.libservices.hours.services" ); 
    beanConfig.setScan( true );
  }
}
