package pl.javastart.apisec.user.dto;

import java.util.Set;

public record UserCredentialsDto(String email, String password, Set<String> roles) {
}
