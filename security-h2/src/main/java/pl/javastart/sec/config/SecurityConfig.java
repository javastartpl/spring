package pl.javastart.sec.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        PathRequest.H2ConsoleRequestMatcher h2ConsoleRequestMatcher = PathRequest.toH2Console();
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers("/").permitAll()
                .requestMatchers(h2ConsoleRequestMatcher).permitAll()
                .requestMatchers("/img/**", "/styles/**").permitAll()
                .requestMatchers("/register", "/confirmation").permitAll()
                .requestMatchers("/secured", "/change-password").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        );
        http.formLogin(login -> login.loginPage("/login").permitAll());
        http.logout(logout ->
                logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout/**", HttpMethod.GET.name()))
                        .logoutSuccessUrl("/")
        );
        http.csrf(csrf -> csrf.ignoringRequestMatchers(h2ConsoleRequestMatcher));
        http.headers(
                config -> config.frameOptions(
                        options -> options.sameOrigin()
                )
        );
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
