package org.gonevertical;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gonevertical.entities.Person;
import org.gonevertical.entities.PhoneNumber;
import org.gonevertical.objectify.OfyFactory;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.googlecode.objectify.Objectify;

@SuppressWarnings("serial")
public class SaveExampleServlet extends HttpServlet {
  
  private HttpServletRequest request;
  private HttpServletResponse response;
  
  /**
   * Objectify Factory which registers the service and classes we need like Person.class
   */
  private Objectify ofy = OfyFactory.init();
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    this.request = request;
    this.response = response;
    
    response.setContentType("text/plain");
    
    example1();
    example2();
    example3();
    example4();
  }
  
  /**
   * Save
   */
  private void example1() throws IOException {
    Person person = new Person("Brandon");
    ofy.save().entities(person).now();
    response.getWriter().println("person=" + person);
    
    // Load
    long id = person.getId();
    person = ofy.load().type(Person.class).id(id).get();
    response.getWriter().println("person=" + person);
  }
  
  /**
   * Save an Array
   */
  private void example2() throws IOException {
    Person[] people = new Person[2];
    people[0] = new Person("Fred");
    people[1] = new Person("Barney");
    ofy.save().entities(people).now();
    response.getWriter().println("people[0]=" + people[0]);
    response.getWriter().println("people[1]=" + people[1]);
  }
  
  /**
   * Save a List
   */
  private void example3() throws IOException { 
    List<Person> people = new ArrayList<Person>();
    people.add(new Person("Fred"));
    people.add(new Person("Barney"));
    ofy.save().entities(people).now();
    response.getWriter().println("people.get(0)=" + people.get(0));
    response.getWriter().println("people.get(1)=" + people.get(1));
  }
 
  /**
   * Save a child with a parent
   */
  private void example4() throws IOException {
    Person person = new Person("Fred Flinstone"); // parent
    ofy.save().entities(person).now();
    person.getId(); // represents datastore key: Person(69)
    response.getWriter().println("person=" + person);
    
    PhoneNumber phone = new PhoneNumber(person); // child
    phone.setPhone("425-308-0000");
    ofy.save().entities(phone).now();
    phone.getId(); // represents datastore key: Person(69)/PhoneNumber(70)
    response.getWriter().println("PhoneNumber=" + phone);
  }
  
}
