package org.gonevertical.guice;

import org.gonevertical.servlets.HomeServlet;

import com.google.inject.servlet.ServletModule;

public class DispatchServletModule extends ServletModule {

  @Override
  public void configureServlets() {
    serve("/").with(HomeServlet.class);
  }
  
}
