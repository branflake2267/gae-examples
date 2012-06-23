package org.gonevertical.objectify;

import javax.inject.Inject;
import org.gonevertical.entities.Person;
import com.googlecode.objectify.ObjectifyFactory;

public class OfyFactory extends ObjectifyFactory {

  @Inject
  public OfyFactory() {
    register(Person.class);
  }

  @Override
  public Ofy begin() {
    return new Ofy(super.begin());
  }

}