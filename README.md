Hello, this is my Second step on Spring-Boot Security (18.01.2024)
AuthController.java
This class is a Spring @RestController responsible for handling authentication-related requests.
It has an endpoint (/login) that accepts POST requests for user login. The login method takes a
LoginRequest object containing the username and password from the request body. It then uses a
UserDetailsService and a PasswordEncoder to validate the user's credentials. If the credentials are valid,
it returns "Login successful!"; otherwise, it returns "Invalid username or password."

LoginRequest.java
This class represents a simple Java object (DTO) used to capture the username and password from the client's login request.
It includes getter and setter methods for accessing and modifying these properties.

SecurityConfig.java
This class is a Spring @Configuration class that configures security settings for the application.
It defines a SecurityFilterChain to handle security configurations. It also provides a PasswordEncoder bean using BCrypt encoding for password security.
The securityFilterChain method configures security settings, disabling CSRF protection and enabling CORS.
It also specifies that requests to the /login endpoint should be permitted without authentication, while any other request must be authenticated.

Additionally, it provides a UserDetailsService bean that creates an in-memory user with the username "learn" and a BCrypt-encoded password "password."

SSecurityApplication.java
This is the main entry point of the Spring Boot application. 
It has the @SpringBootApplication annotation, which includes @Configuration, @EnableAutoConfiguration,
and @ComponentScan. It contains the main method that launches the Spring Boot application.

These components work together to create a simple authentication system using Spring Security,
where users can log in through a /login endpoint, and their credentials are verified against an in-memory user.
The application uses BCrypt password encoding for security.
