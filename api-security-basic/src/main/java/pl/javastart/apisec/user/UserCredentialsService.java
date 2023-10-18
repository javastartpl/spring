package pl.javastart.apisec.user;

import org.springframework.stereotype.Service;
import pl.javastart.apisec.user.dto.UserCredentialsDto;

import java.util.Optional;

@Service
public class UserCredentialsService {

    private final UserRepository userRepository;

    public UserCredentialsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserCredentialsDto> findCredentialsByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserCredentialsDtoMapper::map);
    }
}
