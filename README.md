# Jobs
SpringBoot Example has MYSQL &amp; MongoDB CRUD, Thymeleaf, Swagger Actuator, Logger

[![Build Status](https://travis-ci.org/pritamkhose/jobs.svg?branch=master)](https://travis-ci.org/pritamkhose/jobs)
[![Coverage Status](https://coveralls.io/repos/github/pritamkhose/jobs/badge.svg?branch=master)](https://coveralls.io/github/pritamkhose/jobs?branch=main)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.pritam.jobs.JobsApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
mvn clean install
mvn compile package
```


## References
* [Spring Boot rest CRUD Example](https://stackoverflow.com/questions/28228068/spring-boot-full-rest-crud-example)

* [Spring Boot ResponseEntity<>](https://stackoverflow.com/questions/44497859/is-it-better-to-pass-back-string-or-object-in-the-responseentity)

* [Spring Boot ResponseEntity arguments](https://stackoverflow.com/questions/56780107/cannot-infer-type-arguments-for-responseentity)

* [Spring Boot return html page](https://stackoverflow.com/questions/38700790/how-to-return-a-html-page-from-a-restful-controller-in-spring-boot)

* [Spring Boot environment variables](https://stackoverflow.com/questions/42426438/how-to-set-system-environment-variables-in-applicaton-properties-the-12-factor-w)

* [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/index.html)

* [Spring Boot Pagination sorting](https://howtodoinjava.com/spring-boot2/pagination-sorting-example)

## MongoDB
* [Spring Boot MongoDB](https://www.journaldev.com/18156/spring-boot-mongodb)

* [Spring Boot MongoDB example](https://www.codementor.io/gtommee97/rest-api-java-spring-boot-and-mongodb-j7nluip8d)

* [Spring Boot MongoDB queries](https://www.baeldung.com/queries-in-spring-data-mongodb)
	

## Tools
* [Spring Initializr](https://start.spring.io/)

## Liquibase
* [Example 1](https://docs.liquibase.com/tools-integrations/springboot/using-springboot-with-maven.html) [Github](https://github.com/serlesen/backend-social-network/tree/chapter_6) [more](https://docs.liquibase.com/change-types/sql.html)
* [Example 2](https://github.com/serlesen/backend-social-network) [youtube](https://www.youtube.com/watch?v=uegLZi7-sGc)
* [Liquibase baeldung](https://www.baeldung.com/liquibase-refactor-schema-of-java-app)
* [Supported databases](https://www.liquibase.org/get-started/databases)
* [liquibase-fails error](https://stackoverflow.com/questions/32350054/liquibase-fails-if-computer-is-not-connected-to-internet)
* [Spring Tips_ Reliable Database Migrations with Liquibase and Spring Boot Github](https://github.com/spring-tips/liquibase/blob/master/script.md) [youtube](https://www.youtube.com/watch?v=YhicwD489xQ)
```shell
 mvn liquibase:diff
 mvn liquibase:generateChangeLog
 mvn liquibase:update
```

## Lombok
* [Lombok IDE installation](https://www.baeldung.com/lombok-ide) [features](https://projectlombok.org/features/all)
* [Lombok tutorial](https://medium.com/@udith.indrakantha/say-bye-bye-to-annoying-getters-setters-shorten-your-java-code-with-lombok-d656ae66e163)
* [A Complete Guide to Lombok](https://auth0.com/blog/a-complete-guide-to-lombok/)

## Swagger OpenAPI
* [Swagger OpenAPI](https://www.baeldung.com/spring-rest-openapi-documentation)

## Actuators
* [baeldung](https://www.baeldung.com/spring-boot-actuators)
* [callicoder](https://www.callicoder.com/spring-boot-actuator/)

## Logging
* [logging](https://www.baeldung.com/spring-boot-logging)

## Local Storage
* [File upload local](https://www.bezkoder.com/spring-boot-file-upload/)

* [File upload database](https://www.bezkoder.com/spring-boot-upload-file-database/)

* [callicoder](https://www.callicoder.com/spring-boot-file-upload-download-rest-api-example/)

## Testing
* [Testing the Web Layer](https://spring.io/guides/gs/testing-web/) [Github](https://github.com/spring-guides/gs-testing-web/tree/main/complete)