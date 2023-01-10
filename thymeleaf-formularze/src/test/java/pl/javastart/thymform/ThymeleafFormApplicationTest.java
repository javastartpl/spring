package pl.javastart.thymform;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MultiValueMapAdapter;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ThymeleafFormApplicationTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    PromotionRepository promotionRepository;

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
        MultiValueMapAdapter<String, String> params = new MultiValueMapAdapter<>(new HashMap<>());
        params.add("product", "foo");
        params.add("shop", "bar");
        params.add("originalPrice", "100");
        params.add("discountPrice", "50");
        mockMvc.perform(post("/save").params(params))
                .andExpect(status().is(HttpStatus.FOUND.value()));
        assertEquals(1, promotionRepository.findAll().size());
    }
}
