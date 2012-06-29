package org.gonevertical;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gonevertical.entities.Person;
import org.gonevertical.objectify.OfyFactory;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

@SuppressWarnings("serial")
public class HomeServlet extends HttpServlet {
  
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("text/plain");
    resp.getWriter().println("HomeServlet Works");
    
    Objectify ofy = OfyFactory.init();
    
    Person person = new Person("Brandon");
    ofy.save().entities(person).now();
    resp.getWriter().println("person=" + person);
    
    person.setName("Brandon2");
    ofy.save().entities(person).now();
    resp.getWriter().println("person=" + person);
    
    long id = person.getId();
    person = ofy.load().type(Person.class).id(id).get();
    resp.getWriter().println("person=" + person);
  }
  
}
