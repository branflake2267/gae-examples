package org.gonevertical;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gonevertical.entities.Person;
import org.gonevertical.entities.PhoneNumber;
import org.gonevertical.objectify.OfyFactory;

import com.googlecode.objectify.Objectify;

@SuppressWarnings("serial")
public class LoadExampleServlet extends HttpServlet {

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
    example5();
  }

  /**
   * Load
   */
  private void example1() throws IOException {
    Person person = new Person("Brandon");
    ofy.save().entities(person).now();
    response.getWriter().println("person=" + person);

    long id = person.getId();
    person = ofy.load().type(Person.class).id(id).get();
    response.getWriter().println("person=" + person);
  }

  /**
   * Load Count
   */
  private void example2() throws IOException {
    int count = ofy.load().type(Person.class).count();
    response.getWriter().println("person count=" + count);
  }

  /**
   * Load all with Filter by Name
   */
  private void example3() throws IOException {
    String findName = "Brandon";
    List<Person> list = ofy.load().type(Person.class).filter("name", findName).list();
    for (Person person : list) {
      response.getWriter().println("itemA: person=" + person);
    }
  }
  
  /**
   * Load all with Filter using a wildcard
   */
  private void example4() throws IOException {
    String findName = "Bran";
    List<Person> list = ofy.load().type(Person.class).filter("name <=", findName + "\ufffd").list();
    for (Person person : list) {
      response.getWriter().println("itemB: person=" + person);
    }
  }
  
  /**
   * Save a child with a parent
   */
  private void example5() throws IOException {
    Person person = new Person("Fred Flinstone"); // parent
    ofy.save().entities(person).now();
    person.getId(); // represents datastore key: Person(69)
    response.getWriter().println("person=" + person);
    
    PhoneNumber phone = new PhoneNumber(person); // child
    phone.setPhone("425-308-0000");
    ofy.save().entities(phone).now();
    phone.getId(); // represents datastore key: Person(69)/PhoneNumber(70)
    response.getWriter().println("PhoneNumber=" + phone);
    
    List<PhoneNumber> list = ofy.load().type(PhoneNumber.class).ancestor(person).list();
    for (PhoneNumber item : list) {
      response.getWriter().println("child phone=" + item);
    }
  }
  
}
