package pl.javastart.urls;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WebUrlsApplicationTest {
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
        boolean containsGalleryPic = contentAsString.contains("/images/gallery.png");
        assertTrue(containsGalleryPic);
    }
}
