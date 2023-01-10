package pl.javastart.loops;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class LoopsApplicationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void contextLoads() {

    }

    @Test
    void shouldRespondWithHttp200() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
}
