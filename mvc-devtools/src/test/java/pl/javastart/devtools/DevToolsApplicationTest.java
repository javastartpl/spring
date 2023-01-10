package pl.javastart.devtools;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DevToolsApplicationTest {
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
}
