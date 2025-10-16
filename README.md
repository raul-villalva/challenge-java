# challenge-java-full

Spring Boot CRUD with:
- Spring Web
- Spring Data JPA
- MySQL
- Spring Security + JWT
- Validations (Jakarta Validation)
- Docker / docker-compose

Run with Docker:
- docker-compose up --build


Run with without docker:

- Set line 2 in this file 
      1-challenge-java\src\main\resources\application.properties
- Set the mysql hosts
- And run application locally

Run Migrations
- Although JPA creates all the tables and we could load test users with register api, we could load all the test data that it uses, it is all in the migrations directory.
- Execute after runs the application.

  

Default endpoints:

POST  /api/auth/register
POST  /api/auth/login -> return jwt token


GET   /api/users      (protected)
GET   /api/users/{id} (protected)
POST  /api/users      (protected)
PUT   /api/users/{id} (protected)
DELETE /api/users/{id} (protected)

GET   /posts/{Post}     (protected)
GET   /api/users/{id} (protected)

POST  /api/posts/{userId}  (protected)
PUT   /api/posts/{id} (protected)
DELETE /api/posts/{id} (protected)


