package org.gonevertical.servlets;

import java.io.IOException;
import javax.servlet.http.*;

import org.gonevertical.dao.PersonDao;
import org.gonevertical.entities.Person;

import com.google.inject.Inject;

@SuppressWarnings("serial")
public class HomeServlet extends HttpServlet {

  private PersonDao personDao;

  @Inject
  public HomeServlet(PersonDao personDao) {
    this.personDao = personDao;
  }

  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    resp.setContentType("text/plain");
    resp.getWriter().println("HomeServlet works");

    Person person1 = new Person("Brandon");
    personDao.put(person1);
    resp.getWriter().println("Created Person name=" + person1);
    
    Person person1Get = personDao.get(person1.getId());
    resp.getWriter().println("Get Person name=" + person1Get);
    
    person1.setName("Brandon2");
    personDao.put(person1);
    resp.getWriter().println("Changed Person's name=" + person1);
    
    
    Person person2Get = personDao.get(person1.getId());
    resp.getWriter().println("Get Person name=" + person2Get);
    
    
//    Person person2 = new Person("Fred");
//    personDao.put(person2);
//    resp.getWriter().println("Created Person name=" + person2);
//    
//    Person person3 = new Person("Sam");
//    personDao.put(person3);
//    resp.getWriter().println("Created Person name=" + person3);
  }

}
