package pl.javastart.prg;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PrgApplicationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void contextLoads() {

    }

    @Test
    void shouldRespondWithHttp200() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is(200));
    }

    @Test
    void shouldRedirectAfterPost() throws Exception {
        mockMvc.perform(post("/save").param("id", "foo").param("note", "example note"))
                .andExpect(status().is(HttpStatus.SEE_OTHER.value()));
    }
}
