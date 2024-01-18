package learn.process.sSecurity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;

	public AuthController(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest) {
		UserDetails user = userDetailsService.loadUserByUsername(loginRequest.getUsername());

		if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
			return "Login successful!";
		} else {
			return "Invalid username or password";
		}
	}
}
