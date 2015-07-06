
```
Person person = new Person("Fred Flinstone"); // parent
ofy.save().entities(person).now();
response.getWriter().println("person=" + person);

PhoneNumber phone = new PhoneNumber(person); // child
phone.setPhone("425-308-0000");
ofy.save().entities(phone).now();
response.getWriter().println("PhoneNumber=" + phone);
```