package pl.javastart.fragments;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class FragmentsApplicationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldProcessHomepageTemplate() throws Exception {
        MvcResult homepage = mockMvc.perform(get("/")).andReturn();
        String homepageHtml = homepage.getResponse().getContentAsString();
        assertFalse(homepageHtml.contains("th:replace"));
        assertTrue(homepageHtml.contains("<title>Witaj w Skleppiku</title>"));
    }
}
