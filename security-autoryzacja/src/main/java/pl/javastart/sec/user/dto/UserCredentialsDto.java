package pl.javastart.sec.user.dto;

import java.util.Set;

public class UserCredentialsDto {
    private final String email;
    private final String password;
    private final Set<String> roles;

    public UserCredentialsDto(String email, String password, Set<String> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getRoles() {
        return roles;
    }
}
