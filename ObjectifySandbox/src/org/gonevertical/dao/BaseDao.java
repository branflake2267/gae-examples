package org.gonevertical.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.gonevertical.objectify.Ofy;
import org.gonevertical.objectify.OfyFactory;

import com.googlecode.objectify.Key;

public abstract class BaseDao<T> {
  private final Class<T> clazz;

  @Inject
  OfyFactory ofyFactory;

  private Ofy lazyOfy;

  protected BaseDao(final Class<T> clazz) {
    this.clazz = clazz;
  }

  public ArrayList<T> getAll() {
    return new ArrayList<T>(ofy().query(clazz).list());
  }

  public T put(T object) {
    ofy().save().entity(object).now();

    return ofy().load().entity(object).get();
  }

  public T get(Key<T> key) {
    return ofy().get(key);
  }

  public T get(Long id) {
    return ofy().get(clazz, id);
  }

  public List<T> getSubset(List<Long> ids) {
    return new ArrayList<T>(ofy().query(clazz).ids(ids).values());
  }

  public Map<Long, T> getSubsetMap(List<Long> ids) {
    return new HashMap<Long, T>(ofy().query(clazz).ids(ids));
  }

  public void delete(T object) {
    ofy().delete().entity(object);
  }

  public void delete(List<T> objects) {
    ofy().delete().entities(objects);
  }

  protected Ofy ofy() {
    if (lazyOfy == null) {
      lazyOfy = ofyFactory.begin();
    }
    return lazyOfy;
  }

}
