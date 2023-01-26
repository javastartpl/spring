package pl.javastart.sec;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collection;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void shouldLogout() throws Exception {
		mockMvc.perform(formLogin()
						.user("john")
						.password("asdf1234"))
				.andExpect(status().isFound())
				.andExpect(redirectedUrl("/"));
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

}
