package org.gonevertical.entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;

@Entity
public class PhoneNumber {

  @Parent
  private Person person;
  
  @Id
  private Long id;

  private String phone;

  private PhoneNumber() {
  }
  
  public PhoneNumber(Person person) {
    this.person = person;
  }

  public Person getPerson() {
    return person;
  }
  public void setPerson(Person person) {
    this.person = person;
  }
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  
  public String toString() {
    String s = "";
    s += "parent=" + person + " ";
    s += "id=" + id + " ";
    s += "phone=" + phone + " ";
    return s;
  }
  
}
