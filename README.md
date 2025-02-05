# Ticket Booking System

### Prerequisites

- Java 11 or higher
- Maven
- MySQL

Since the applocatopm uses `spring.jpa.hibernate.ddl-auto=update` all the tables will be created automatically,
but the schema needs to be created manually.

```sql
CREATE SCHEMA `movies`;
```

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/yoav42/att.git
    ```

2. Build the project:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn spring-boot:run
    ```

# Notes:
The `POST /auth/register` endpoint expects a role for the user.
This is not secure and for testing purpose, so we can create the first ADMIN and CUSTOMER users.

### Swagger UI

Access the Swagger UI for API documentation at:
http://localhost:8080/swagger-ui.html

### Flow example
* Create an admin user with `/auth/register`
* Create a customer user with `/auth/register`
* Login with the admin user with `/auth/login`
* Create a movie with `POST /movies`
* Create a showtime with `POST /showtimes`
* Try to create another showtime in the same time interval and get a conflict error
* Login with customer
* Buy a ticket with `POST /bookings` with a seat
* Try to buy the same seat and get a conflict error
* Keep playing with it :)