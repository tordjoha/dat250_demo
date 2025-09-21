# Experiment 4: JPA

## Technical problems during installation and use of JPA and how I resolved it
- Had to change imports to own package name
- I had added an UUID when creating a new user, but with the database being the one to assign one, I removed it
- Some methods were missing when importing the PollsTest.java, so I had to update the classes somewhat to incorporate these new methods
- Have problems with storing the polls after creation, a getAllPolls() returns an empty list. I have made sure that the 
PollManager gets instantiated as the same object, and not with "new ...", but I cant seem to find out why it does not
store the data. This means that the tests from PollsTest do not yet pass, as polls cannot be modified or found after creation,
making it not possible to add voting options or votes to them.

## Link to code for experiment
[code file here]

## Explanation of how I inspected the database tables and what tables were created. Provide screenshots of created tables

## Pending issues which I did not manage to solve
- Have trouble with storing of polls, I can create them but when trying to retrieve, I get an empty list "[]"
- "java.lang.IllegalArgumentException: Entity may not be null
  at org.hibernate.event.spi.PersistEvent.<init>(PersistEvent.java:27)
  at org.hibernate.event.spi.PersistEvent.<init>(PersistEvent.java:20)
  at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:676)
  at com.example.demo.PollsTest.populate(PollsTest.java:40)
  at com.example.demo.PollsTest.lambda$setUp$0(PollsTest.java:59)"
- -> I think this issue is due to me not being able to store the poll properly, so I would need to fix this before being able to create the tables