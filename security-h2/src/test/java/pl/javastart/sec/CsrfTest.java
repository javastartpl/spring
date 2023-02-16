package pl.javastart.sec;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CsrfTest {

    @LocalServerPort
    String localPort;

    @Autowired
    WebTestClient webClient;

    @Test
    void shouldNotRegisterWithoutCsrf() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("email", "asdf@example.com");
        params.add("password", "abc");
        params.add("firstName", "John");
        params.add("lastName", "Doe");

        webClient.post()
                .uri("/register")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(params))
                .exchange()
                .expectStatus().isFound()
                .expectHeader().valueMatches("location", "http://localhost:[0-9]{5}/login.*");
    }
}
