# Spring REST Data POC

This project demonstrates a Proof of Concept (POC) for building a RESTful API using Spring Data REST and Spring Boot. It implements a simple car management system with automated REST endpoint generation.

## Overview

The application showcases how to:
- Create REST APIs automatically using Spring Data REST
- Implement JPA entities with H2 database
- Use Spring Data repositories with custom query methods
- Integrate Swagger/OpenAPI documentation

## Technologies Used

- Java 24
- Spring Boot
- Spring Data JPA
- Spring Data REST
- H2 Database
- Swagger/OpenAPI 3.0

## Entity Structure

The application manages `Car` entities with the following properties:
- id (Long)
- name (String)
- year (Integer)
- color (String)
- price (Integer)
- horsePower (Integer)

## API Documentation

The API documentation is available through Swagger UI at:
[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)


![Swagger UI Interface](screenshots/swagger-ui.png)

## Available Endpoints

The following REST endpoints are automatically generated:

### Car Operations
- `GET /cars` - List all cars (with pagination support)
- `POST /cars` - Create a new car
- `GET /cars/{id}` - Get a specific car by ID
- `PUT /cars/{id}` - Update a car
- `DELETE /cars/{id}` - Delete a car
- `GET /cars/search/findByName?name={name}` - Find cars by name

## Setup and Running

1. Clone the repository
2. Make sure you have Java 24 installed
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Access the H2 Console at `http://localhost:8080/h2-console` (if enabled)
    - JDBC URL: `jdbc:h2:mem:testdb`
    - Username: `sa`
    - Password: (empty)

## Example Requests

### Create a Car
```bash
curl -X POST http://localhost:8080/cars \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Tesla Model 3",
    "year": 2023,
    "color": "Red",
    "price": 45000,
    "horsePower": 283
  }'
```

### Find Cars by Name
curl http://localhost:8080/cars/search/findByName?name=Tesla%20Model%203

## Repository Structure
The project uses Spring Data repositories with the following interfaces:
- - For pagination and sorting support `PagingAndSortingRepository`
- - For basic CRUD operations `CrudRepository`

Custom query methods are defined in the interface using Spring Data's method naming conventions. `CarRepository`
## Configuration
The application uses an H2 in-memory database by default. Configuration can be found in : `application.properties`

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true

