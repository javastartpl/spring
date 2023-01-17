package pl.javastart.arch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ArchApplicationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldReturnCompany() throws Exception {
        mockMvc.perform(get("/companies/1"))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("id", is(1))
                ).andDo(print());
    }

    @Test
    void shouldSaveCompany() throws Exception {
        String company = """
                {
                    "name": "ACME",
                    "description": "Jesteśmy nową, ale prężnie rozwijającą się firmą z sektora IT",
                    "city": "Kraków",
                    "employees": 5,
                    "telephone": "48 111-222-333",
                    "email": "contact@acme.org"
                }""";
        mockMvc.perform(post("/companies").content(company).contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        status().isCreated(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("id", is(3))
                ).andDo(print());
    }

    @Test
    void shouldAddJobOfferToCompany() throws Exception {
        String jobOffer = """
                {
                    "title": "Junior Java Developer",
                    "description": "Rozpocznij z nami karierę jako programista Java",
                    "requirements": "Ukończone studia informatyczne, znajomość Javy 8+, frameworków Spring i Hibernate",
                    "duties": "Rozwój istniejącej aplikacji o rezerwacji pod okiem starszych programistów",
                    "location": "Poznań",
                    "minSalary": 4000.0,
                    "maxSalary": 5000.0,
                    "companyId": 1
                }""";
        mockMvc.perform(post("/offers").content(jobOffer).contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        status().isCreated(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("id", is(4))
                ).andDo(print());
    }
}
