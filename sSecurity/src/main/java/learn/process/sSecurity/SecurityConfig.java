package learn.process.sSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // BCryptPasswordEncoder bean'ini döndüren metot.
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Güvenlik filtresi zincirini yapılandıran metot.
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> {
            csrf.disable();
        }).cors(cors -> cors.disable()).authorizeHttpRequests(auth -> {
            auth.requestMatchers("/login/**").permitAll(); // /login/** yolu herkese açıktır.
            auth.anyRequest().authenticated(); // Diğer tüm istekler için kimlik doğrulama gerekir.
        }).build();
    }

    // Kullanıcı detaylarını sağlayan metot.
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // Şifreyi BCryptPasswordEncoder kullanarak kodla ve bir UserDetails nesnesi oluştur.
        String encodedPassword = passwordEncoder.encode("password");
        UserDetails admin = User.builder().username("learn").password(encodedPassword).roles("USER").build();

        // InMemoryUserDetailsManager kullanarak oluşturduğumuz UserDetails nesnesini kullanıcı detaylarını sağlayıcı olarak döndür.
        return new InMemoryUserDetailsManager(admin);
    }
}
