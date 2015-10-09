### Overview
Two applications that fulfill the Command Query Responsibilities Segregation (CQRS) pattern implementation.

### CQRS in simple terms
  CQRS stands for Command Query Responsibility Segregation. It is a design pattern that enforces the separation of actions that modify the state of an application and the actions that leave the state of the application intact.
* Quote from the [inventor's paper](https://cqrs.files.wordpress.com/2010/11/cqrs_documents.pdf): "objects are split into two objects, one containing the Commands one containing the Queries."
* [Idea behind the design](https://en.wikipedia.org/wiki/Command%E2%80%93query_separation) : Asking a question should not change the answer.
* Java terms:  If you have a return value you cannot mutate state. If you mutate state your return type must be void.

Two important terms here are:
* Command: code execution that modifies(mutate) the application's state, In java this would represent all "setter" methods.
* Query: code execution that **does not** modifies(mutate) the application's state, In java this would represent all "getter" methods.

### Spring application - original architechture 
This is implemented in the [Spring Boot 102](http://fuse-mars.github.io/spring-boot-102)

### Spring application - cqrs based architechture
We are going to split into two, the [project](https://github.com/fuse-mars/spring-boot-102) that we built in [spring-boot-102 tutorial](). One that processes commands and another that processes queries. Below is the schematic representation of what this separation looks like.

![Architecture schema](https://raw.githubusercontent.com/fuse-mars/spring-boot-103/master/tutorial-resource/architecture-schema.png)

In the original architecture
* Step 1: user sends a POST request to save data
* Step 2: application responds with the **save data or data related errors**
* Step 3: user sends a GET request to read the saved data
* Step 4: application responds with the save data or request related errors 

In the CQRS based architecture
* Step 1: user sends a POST request to save data
* Step 2: application responds with an **ACK/NACK message** saying that the POST request has been received or has been rejected.
* Step 3: user sends a GET request to read the saved data.
* Step 4: application responds with the save data or request related errors.

### Technology
* [Gradle](https://gradle.org/)
* [Spring Boot](http://projects.spring.io/spring-boot/)
* [Spring Data](http://projects.spring.io/spring-data/)

### Step followed
* Add a mysql database:  We can't use the in-memory database anymore because both applications have to access the same datastore.
  * Make sure you have a mysql database management server running locally, I use [MAMP](https://www.mamp.info/en/) 
  * add dependency 
```
# build.gradle
# compile 'com.h2database:h2' removed
compile 'mysql:mysql-connector-java' # added
```
  * add configuration values
```
touch application.properties
```
```
# content of the application.properties

spring.datasource.url=jdbc:mysql://localhost/springboot103
spring.datasource.username=spring
spring.datasource.password=spring
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = update
spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect


```
  * Create a database called `springboot103`
  * Create a user/password `spring/spring` with read write access to the just created databse

* Create command handler application: 
  * This app is almost the same as the old application except, we disabled the all request methods except POST and DELETE,  The getters method have also been removed, and the response returned to the user is now an acknowledgment instead of the saved object.

```
TODO add code snippets
```

* Create Query handler application: 
  * We have removed the setters from the object model. 

```
TODO add code snippets
```

### Other main usage of CQRS
**Event sourcing:** 

Definition: 
* Event sourcing is a way of persisting your application's state by storing the history that determines the current state of your application. "From [Microsoft](https://msdn.microsoft.com/en-us/library/jj591559.aspx)"

Usage (with CQRS):
* Every command initiate a task execution
* Every successful task execution is accompanied with an event, which is basically a historical record describing the impact of this task execution on the system’s state.
  * For restful applications, System’s state is represented by the datastore
  * For stateful applications, System’s state is represented by the state of objects in memory
  * Here is good explanation: [stateless vs statefull](http://programmers.stackexchange.com/questions/101337/whats-the-difference-between-stateful-and-stateless)

* By analyzing(replaying) all events in order, you should get the present state of the system
* Below is an example from [Benjamin and Johannes' tutorial](https://ookami86.github.io/event-sourcing-in-practice)
```
Image here
```
* Note that that this can also be used when responding to queries
  * If you want to keep track how often users access your application


### Resource:
* https://cqrs.files.wordpress.com/2010/11/cqrs_documents.pdf
* https://en.wikipedia.org/wiki/Command%E2%80%93query_separation
* https://github.com/netgloo/spring-boot-samples/blob/master/spring-boot-mysql-springdatajpa-hibernate/src/main/resources/application.properties
