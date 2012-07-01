package org.gonevertical.entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Person {

  @Id
  private Long id;
  
  @Index
  private String name;
  
  private int age;

  public Person() { 
  }

  public Person(String name) {
    this.name = name;
  }
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  
  public String toString() {
    String s = "";
    s += "id=" + getId() + " ";
    s += "name=" + name + " ";
    s += "age=" + age + " ";
    return s;
  }
  
}
