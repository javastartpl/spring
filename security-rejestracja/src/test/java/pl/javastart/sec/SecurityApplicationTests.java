package pl.javastart.sec;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
						.user("superadmin@example.com")
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
		mockMvc.perform(get("/secured").with(user("mockuser")))
				.andExpect(model().attributeExists("welcomeMessage"))
				.andExpect(model().attribute("welcomeMessage", "Hello mockuser"));
	}

	@Test
	void userShouldNotHaveAccessToAdminPanel() throws Exception {
		mockMvc.perform(get("/admin").with(user("mockuser").roles("USER")))
				.andExpect(status().isForbidden());
	}

	@Test
	void shouldRegister() throws Exception {
		mockMvc.perform(post("/register")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("email", "asdf@example.com")
				.param("password", "abc")
				.param("firstName", "John")
				.param("lastName", "Doe")
		).andExpect(redirectedUrl("/confirmation"));
	}

}
