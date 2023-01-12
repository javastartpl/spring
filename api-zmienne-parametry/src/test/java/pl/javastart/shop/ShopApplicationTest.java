package pl.javastart.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

@SpringBootTest
@AutoConfigureMockMvc
class ShopApplicationTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldReturnProduct() throws Exception {
        Product product = new Product(1, "Mleko", 3.8, new Producer("Mleczex", new Address("Warszawa", "20-222", "Wysoka 20")));
        String productAsString = objectMapper.writeValueAsString(product);
        mockMvc.perform(get("/products/1"))
                .andExpectAll(
                        header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE),
                        content().string(productAsString)
                );
    }

    @Test
    void shouldReturnProducer() throws Exception {
        Producer producer = new Producer("Mleczex", new Address("Warszawa", "20-222", "Wysoka 20"));
        String producerAsString = objectMapper.writeValueAsString(producer);
        mockMvc.perform(get("/products/1/producer"))
                .andExpectAll(
                        header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE),
                        content().string(producerAsString)
                );
    }
}
