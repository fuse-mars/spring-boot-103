# spring-boot-103
Two applications that fulfill the Command Query Responsibilities Segregation (CQRS) pattern implementation.

### CQRS in simple terms
  CQRS stands for Command Query Responsibility Segregation. It is a design pattern that enforces the separation of actions that modify the state of an application and the actions that leave the state of the application intact.
* Qoute from the [inventor's paper](https://cqrs.files.wordpress.com/2010/11/cqrs_documents.pdf): "objects are split into two objects, one containing the Commands one containing the Queries."
* [Idea behind the design](https://en.wikipedia.org/wiki/Command%E2%80%93query_separation) : Asking a question should not change the answer.

### Spring application - old style 
This is implemented in the [Spring Boot 102](http://fuse-mars.github.io/spring-boot-102)

### Spring application - cqrs style

TODO
