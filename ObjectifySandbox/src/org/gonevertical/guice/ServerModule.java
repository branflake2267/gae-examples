package org.gonevertical.guice;

import org.gonevertical.servlets.HomeServlet;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class ServerModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(HomeServlet.class).in(Singleton.class);
  }

}
