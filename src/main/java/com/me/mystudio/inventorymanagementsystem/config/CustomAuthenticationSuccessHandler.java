package com.me.mystudio.inventorymanagementsystem.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * This class is responsible for handling successful authentication events.
 * 
 * The method checks the role of the user and redirects he to the appropriate
 * dashboard.
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     * Redirects the user to the appropriate dashboard based on their role.
     *
     * @param request        the HttpServletRequest object
     * @param response       the HttpServletResponse object
     * @param authentication the Authentication object
     * @throws IOException if an error occurs during redirection
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        authorities.forEach(authority -> {
            try {
                if (authority.getAuthority().equals("ROLE_USER")) {
                    redirectStrategy.sendRedirect(request, response, "/user/dashboard");
                } else if (authority.getAuthority().equals("ROLE_ADMIN")) {
                    redirectStrategy.sendRedirect(request, response, "/admin/dashboard");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}