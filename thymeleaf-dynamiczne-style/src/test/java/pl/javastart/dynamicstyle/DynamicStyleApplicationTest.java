package pl.javastart.dynamicstyle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DynamicStyleApplicationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldRespondWithHttp200() throws Exception {
        String contentAsString = mockMvc.perform(get("/"))
                .andExpect(status().is(200))
                .andReturn().getResponse().getContentAsString();
        boolean containsMockText = contentAsString.contains("Jan2");
        boolean containsThAttribute = contentAsString.contains("th:");
        assertFalse(containsMockText);
        assertFalse(containsThAttribute);
    }
}
