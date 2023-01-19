package pl.javastart.validation;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ValidationApplicationTest {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {

    }

    @Test
    @DisplayName("Should throw ConstraintViolationException for client with invalid age")
    void shouldNotPersistInvalidClient() {
        Client client = new Client("Jan", "Kowalski", "kowaljan@abc.com", -10);
        assertThrows(ConstraintViolationException.class, () -> clientRepository.save(client));
    }

    @Test
    void shouldPersistValidClient() {
        Client client = new Client("Jan", "Kowalski", "kowaljan@abc.com", 10);
        client.setUsername("JAKO123");
        assertDoesNotThrow(() -> clientRepository.save(client));
    }

    @Test
    void shouldRedirectForValidClient() throws Exception {
        mockMvc.perform(post("/register")
                        .queryParam("firstName", "Jan")
                        .queryParam("lastName", "Kowalski")
                        .queryParam("email", "jan@kowalski.org")
                        .queryParam("age", "10"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void shouldBindResultForInvalidClient() throws Exception {
        String viewName = mockMvc.perform(post("/register")
                        .queryParam("firstName", "Jan")
                        .queryParam("lastName", "Kowalski")
                        .queryParam("email", "asdf")
                        .queryParam("age", "-10"))
                .andExpect(status().isOk())
                .andReturn()
                .getModelAndView()
                .getViewName();
        assertEquals("index", viewName);
    }
}
