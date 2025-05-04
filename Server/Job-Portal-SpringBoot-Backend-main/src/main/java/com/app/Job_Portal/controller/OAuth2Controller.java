package com.app.Job_Portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Job_Portal.dto.SignInResponseDto;
import com.app.Job_Portal.service.OAuth2Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/oauth2")
public class OAuth2Controller {

    @Autowired
    private OAuth2Service oAuth2Service;

    @GetMapping("/success")
    public void handleOAuthSuccess(@AuthenticationPrincipal OAuth2User principal, HttpServletResponse response)
            throws IOException {
        try {
            SignInResponseDto userInfo = oAuth2Service.processOAuthPostLogin(principal);
            // Redirect to frontend with user info as query params
            String redirectUrl = String.format(
                    "http://localhost:3000/home?userId=%s&email=%s&role=%s",
                    userInfo.getId(),
                    userInfo.getEmail(),
                    userInfo.getRole());
            response.sendRedirect(redirectUrl);
        } catch (Exception e) {
            response.sendRedirect("http://localhost:3000/signin?error=" + e.getMessage());
        }
    }
}