package pl.javastart.sec.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests.anyRequest().authenticated());
        http.csrf().disable();
        http.formLogin(login -> login.loginPage("/login").permitAll());
//        http.logout(logout -> logout
//                .logoutSuccessUrl("/byebye")
//                .permitAll()
//        );
    }
}
