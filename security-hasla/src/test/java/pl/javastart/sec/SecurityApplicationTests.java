package pl.javastart.sec;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	@WithMockUser
	void shouldLogout() throws Exception {
		mockMvc.perform(logout())
				.andExpect(redirectedUrl("/login?logout"))
				.andExpect(unauthenticated());
	}

	@Test
	void shouldLoginAsAdmin() throws Exception {
		mockMvc.perform(formLogin()
						.user("superadmin")
						.password("hard"))
				.andExpect(status().isFound())
				.andExpect(redirectedUrl("/"))
				.andExpect(authenticated().withRoles("ADMIN"));
	}

	@Test
	void shouldNotLoginWithWrongCredentials() throws Exception {
		mockMvc.perform(formLogin()
						.user("notexit")
						.password("wrongpassword"))
				.andExpect(status().isFound())
				.andExpect(redirectedUrl("/login?error"))
				.andExpect(unauthenticated());
	}

	@Test
	void shouldContainWelcomeMessage() throws Exception {
		mockMvc.perform(get("/").with(user("mockuser")))
				.andExpect(model().attributeExists("welcomeMessage"))
				.andExpect(model().attribute("welcomeMessage", "Hello mockuser"));
	}

}
