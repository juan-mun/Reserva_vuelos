import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/css/**", "/img/**").permitAll() // Permite el acceso a CSS e imágenes
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login") // Ruta personalizada para la página de inicio de sesión
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }
}
