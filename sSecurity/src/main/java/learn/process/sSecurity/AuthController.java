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

    // AuthController sınıfının kurucu yöntemi.
    public AuthController(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    // Kullanıcı girişi için POST isteğini işleyen metot.
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // Kullanıcı Detay Servisinden ilgili kullanıcının detaylarını al.
        UserDetails user = userDetailsService.loadUserByUsername(loginRequest.getUsername());

        // Eğer kullanıcı varsa ve girilen şifre ile kayıtlı şifre eşleşiyorsa giriş başarılıdır.
        if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid username or password";
        }
    }
}
