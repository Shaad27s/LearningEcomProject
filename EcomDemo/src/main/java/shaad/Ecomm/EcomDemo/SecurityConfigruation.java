package shaad.Ecomm.EcomDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigruation {
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(customizer->customizer.disable());
        http.authorizeHttpRequests((request -> request.
                requestMatchers("/api").permitAll().
                requestMatchers("/home").permitAll().
                requestMatchers("/list").permitAll().
                anyRequest().authenticated()));
        http.httpBasic(Customizer.withDefaults());
        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
     //   http.addFilter()

        return http.build();
    }

}
