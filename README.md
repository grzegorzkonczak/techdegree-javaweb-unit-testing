## Java unit testing
This project was aimed at practicing unit testing for WIP (work in progress) application.
Application was meant to mimic Stack Overflow in functionality, project initial files where provided with skeleton of application and set of requirements for test.
The requirements where:

1. Test to ensure that questioner's reputation goes up by 5 points if their question is upvoted.

2. Test to ensure that answerer's reputation goes up by 10 points if their answer is upvoted.

3. Test to ensure that answerer's reputation goes up by 15 points if their answer is accepted.

4. Tests to ensure that original author of question or answer can't upvote or downvote his question/answer.

5. Tests to ensure that only original author of question can accept answer for it.

6. Tests to ensure that down voting question does not change reputation of questioneer
 and down voting answer reduces reputation of answer author by 1.
 
Below is code snippet from application that was tested.

## Welcome to Stack Overboard

This is a WIP (Work In Progress) but the basic idea is this:

```java
// A board is a topic area on a bulletin board
Board board = new Board("Java");

// Create new users from the board
User alice = board.createUser("alice");
User bob = board.createUser("bob");
User charles = board.createUser("charles");

// Users create questions
Question question = alice.askQuestion("What is a String?");
// They can be upvoted
bob.upVote(question);

// Users can also answer questions
Answer answer = bob.answerQuestion(question, "It is a series of characters, strung together...");
// Answers can be upvoted
alice.upVote(answer);

// and downvoted
charles.downVote(answer);
charles.downVote(answer);

// and accepted by the person who asked the question
alice.accept(answer);

// There is then reputation
System.out.println("Alice: " + alice.getReputation()); // Alice's question got upvoted so this prints Alice: 5
System.out.println("Bob: " + bob.getReputation()); // Bob's answer got upvoted (10) and his answer was accepted (15)
                                                   // so this prints Bob: 25
```

To check my other work please go to:

- https://github.com/grzegorzkonczak/instateam-with-spring-and-hibernate - Project team management web application using Spring with Hibernate.
- https://github.com/grzegorzkonczak/todo-api-with-spark - REST API for "TODO" application using Spark framework
- https://github.com/grzegorzkonczak/analyze-public-data-with-hibernate - Console application for managing Countries data using Hibernate and H2 file database.
- https://github.com/grzegorzkonczak/countries-of-the-world-with-spring - Spring web application that displays information about 5 countries
- https://github.com/grzegorzkonczak/personal-blog - Simple web blog application built using Spark Framework
- https://github.com/grzegorzkonczak/Soccer-League-Organizer - Console based soccer team management application
- https://github.com/grzegorzkonczak/how_many_in_jar_game - Console based implementation of "How many in jar" game
