package com.tosan.bookstore.configs.handlers;

import com.tosan.bookstore.services.AuthenticationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final AuthenticationService _authenticationService;

    public CustomAuthenticationSuccessHandler(AuthenticationService authenticationService) {
        _authenticationService = authenticationService;
    }

    @Override
    public void onAuthenticationSuccess(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final Authentication authentication) throws IOException, ServletException {

        _authenticationService.logSuccessfulLogin(request.getParameter("username"));

        var redirectURL = "/home";
        super.setDefaultTargetUrl(redirectURL);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
