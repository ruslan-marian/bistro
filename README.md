# Recipes API Backend

This is a simple API for recipes and ingredients. The customer could be 
a French-style bistro.



## Quick start

1. Use Git to clone this repo.
1. To build the project: `./mvnw clean install`.
1. To serve it: `./mvnw spring-boot:run`.
1. To test: `http://localhost:8080`.



## Project description

The project is built with [Spring Boot](http://spring.io/projects/spring-boot) 
and these Starters and dependencies:

1. Web - Full-stack web development with Tomcat.
1. JPA - Java Persistence API including spring-data-jpa, spring-orm and Hibernate
1. H2 - H2 database (with embedded support)
1. DevTools - Spring Boot Development Tools

The embedded database is initialized automatically at startup. This is
enabled by placing the **data.sql** file in the `src/main/resources` folder.



## Spring Boot Development Tools

The development tools are enabled by default. This is done by setting the
property `spring.h2.console.enabled=true` at the file **application.properties**.

The database can be explored from the H2 console: 
  
1. To access the database open `http://localhost:8080/h2-console`.
1. Make sure H2 console uses JDBC URL `jdbc:h2:mem:testdb`.
1. Query the tables `ingredient` and `recipe` to see their data.



## References

[Spring Initializr](https://start.spring.io/)  
[Building a RESTful Web Service](http://spring.io/guides/gs/rest-service/#scratch)  
[Spring Boot and H2 in memory database](http://www.springboottutorial.com/spring-boot-and-h2-in-memory-database)
[Spring Boot Reference Guide](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#getting-started-first-application-pom)

