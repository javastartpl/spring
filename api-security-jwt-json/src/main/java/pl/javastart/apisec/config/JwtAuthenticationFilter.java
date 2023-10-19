package pl.javastart.apisec.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.io.IOException;

class JwtAuthenticationFilter extends HttpFilter {
    private final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    private static final RequestMatcher DEFAULT_ANT_PATH_REQUEST_MATCHER = new AntPathRequestMatcher("/auth", "POST", false);
    private final AuthenticationManager authenticationManager;
    private final AuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();
    private final AuthenticationSuccessHandler successHandler;

    JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        successHandler = new JwtAuthenticationSuccessHandler(jwtService);
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        if (!DEFAULT_ANT_PATH_REQUEST_MATCHER.matches(request)) {
            filterChain.doFilter(request, response);
        } else {
            try {
                Authentication authenticationResult = attemptAuthentication(request);
                logger.debug("Authentication success for user " + authenticationResult.getName());
                this.successHandler.onAuthenticationSuccess(request, response, authenticationResult);
            } catch (AuthenticationException e) {
                logger.debug("Authentication failed " + e.getMessage());
                this.failureHandler.onAuthenticationFailure(request, response, e);
            }
        }
    }

    private Authentication attemptAuthentication(HttpServletRequest request) throws AuthenticationException, IOException {
        JwtAuthenticationToken jwtAuthentication = new ObjectMapper().readValue(request.getInputStream(), JwtAuthenticationToken.class);
        logger.debug("Authenticating %s with password %s".formatted(jwtAuthentication.username, jwtAuthentication.password));
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(jwtAuthentication.username(), jwtAuthentication.password());
        return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    }

    private record JwtAuthenticationToken(String username, String password){}

}
