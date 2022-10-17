package com.tosan.bookstore.configs.handlers;

import com.tosan.bookstore.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private final AuthenticationService _authenticationService;

    public CustomAuthenticationFailureHandler(AuthenticationService authenticationService) {
        _authenticationService = authenticationService;
    }

    @Override
    public void onAuthenticationFailure(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final AuthenticationException exception) throws IOException, ServletException {

        _authenticationService.logFailedLogin(request.getParameter("username"));

        var error = "auth.unexpected";
        if (exception instanceof UsernameNotFoundException) {
            error = "auth.notFound";
        } else if (exception instanceof DisabledException) {
            error = "auth.disabled";
        } else if (exception instanceof BadCredentialsException) {
            error = "auth.credentials.invalid";
        } else if (exception instanceof SessionAuthenticationException) {
            error = "auth.session";
        } else if (exception instanceof LockedException) {
            error = "auth.locked";
        } else if (exception instanceof AccountExpiredException) {
            error = "auth.expired";
        } else if (exception instanceof CredentialsExpiredException) {
            error = "auth.credentials.expired";
        }

        var redirectURL = "/user/login?error=" + error;
        super.setDefaultFailureUrl(redirectURL);
        super.setUseForward(true);
        super.onAuthenticationFailure(request, response, exception);
    }
}
