package pl.javastart.sec.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
class CustomInMemoryUserDetailsManager extends InMemoryUserDetailsManager {

    public CustomInMemoryUserDetailsManager() {
        User.UserBuilder userBuilder = User.builder();
        UserDetails admin = userBuilder.username("superadmin").password("{noop}hard").roles("ADMIN").build();
        UserDetails user1 = userBuilder.username("john").password("{noop}asdf1234").roles("USER").build();
        createUser(admin);
        createUser(user1);
    }
}
