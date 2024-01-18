AuthController.java
This class serves as a Spring @RestController responsible for handling authentication-related requests. It features an endpoint (/login) designed to handle POST requests for user login. The login method takes a LoginRequest object containing the username and password from the request body. It leverages a UserDetailsService and a PasswordEncoder to validate the user's credentials. If the credentials are valid, it returns "Login successful!"; otherwise, it returns "Invalid username or password."

LoginRequest.java
This class represents a simple Java object (DTO) tasked with capturing the username and password from the client's login request. It includes getter and setter methods for convenient access and modification of these properties.

SecurityConfig.java
As a Spring @Configuration class, SecurityConfig plays a pivotal role in configuring security settings for the application. It defines a SecurityFilterChain to handle security configurations and provides a PasswordEncoder bean utilizing BCrypt encoding for robust password security.

The securityFilterChain method configures security settings, disabling CSRF protection, enabling CORS, and specifying that requests to the /login endpoint should be permitted without authentication. Conversely, any other request must be authenticated.

Furthermore, it offers a UserDetailsService bean that creates an in-memory user with the username "learn" and a BCrypt-encoded password "password."

SSecurityApplication.java
Serving as the main entry point of the Spring Boot application, SSecurityApplication bears the @SpringBootApplication annotation, encapsulating @Configuration, @EnableAutoConfiguration, and @ComponentScan. The main method within launches the Spring Boot application.

These components synergize to establish a straightforward authentication system using Spring Security. Users can log in through the /login endpoint, and their credentials undergo verification against an in-memory user. BCrypt password encoding ensures robust security for the application.
