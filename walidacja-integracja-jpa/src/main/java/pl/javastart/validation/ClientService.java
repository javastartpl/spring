package pl.javastart.validation;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void register(Client client) {
        String uniqueUsername = generateUsername(client);
        client.setUsername(uniqueUsername);
        clientRepository.save(client);
    }

    private String generateUsername(Client client) {
        String firstNameLetters = client.getFirstName().substring(0, 2).toUpperCase();
        String lastNameLetters = client.getLastName().substring(0, 2).toUpperCase();
        String usernameBeginning = firstNameLetters + lastNameLetters;
        String username;
        do {
            username = usernameBeginning + randomCode(3);
        } while (clientRepository.existsByUsername(username));
        return username;
    }

    private String randomCode(int length) {
        List<String> digits = Arrays.asList("0123456789".split(""));
        Collections.shuffle(digits);
        return digits.subList(0, length).stream().reduce(String::concat).get();
    }
}
