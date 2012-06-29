package org.gonevertical.dao;

import org.gonevertical.entities.Person;

public class PersonDao extends BaseDao<Person> {

  protected PersonDao() {
    super(Person.class);
  }

}
