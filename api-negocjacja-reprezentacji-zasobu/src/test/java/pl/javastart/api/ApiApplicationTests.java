package pl.javastart.api;

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
class ApiApplicationTests {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldReturnJsonBook() throws Exception {
        Book book = new Book("Harry Potter", "J.K. Rowling", 1997, 223);
        String bookJson = objectMapper.writeValueAsString(book);
        mockMvc.perform(get("/api/books/1"))
                .andExpectAll(
                        header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE),
                        content().json(bookJson)
                );
    }

    @Test
    void shouldReturnXmlResponse() throws Exception {
        mockMvc.perform(get("/api/books/1").header("Accept", MediaType.APPLICATION_XML_VALUE))
                .andExpect(header().string("Content-Type", MediaType.APPLICATION_XML_VALUE));
    }

}
