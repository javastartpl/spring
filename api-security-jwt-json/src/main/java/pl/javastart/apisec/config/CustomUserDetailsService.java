package pl.javastart.apisec.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.javastart.apisec.user.UserCredentialsService;
import pl.javastart.apisec.user.dto.UserCredentialsDto;

@Service
class CustomUserDetailsService implements UserDetailsService {
    private final UserCredentialsService userService;

    public CustomUserDetailsService(UserCredentialsService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.findCredentialsByEmail(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not found", username)));
    }

    private UserDetails createUserDetails(UserCredentialsDto credentials) {
        return User.builder()
                .username(credentials.email())
                .password(credentials.password())
                .roles(credentials.roles().toArray(String[]::new))
                .build();
    }
}
