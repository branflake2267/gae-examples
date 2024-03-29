package org.gonevertical.objectify;

import org.gonevertical.entities.Person;
import org.gonevertical.entities.PhoneNumber;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;

public class OfyFactory extends ObjectifyFactory {

  public static Objectify init() {
    return new OfyFactory().begin();
  }

  public OfyFactory() {
    register(Person.class);
    register(PhoneNumber.class);
  }

  @Override
  public Objectify begin() {
    return super.begin();
  }

}