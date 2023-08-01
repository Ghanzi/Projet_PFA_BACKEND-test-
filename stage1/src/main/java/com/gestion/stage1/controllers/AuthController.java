package com.gestion.stage1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/")
public class AuthController {

    RestTemplate restTemplate = new RestTemplate();

    @Value("${jwt.auth.converter.resource-id}")
    private String resourceId;

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String path_realm;


    private JavaMailSender javaMailSender;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, Object> input) {

        String username = (String) input.get("username");
        String password = (String) input.get("password");

        // Create the request body with grant type, client ID, username, and password
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "password");
        requestBody.add("client_id", resourceId);
        requestBody.add("username", username);
        requestBody.add("password", password);

        // Create the headers for the request
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");

        // Create the HTTP entity with the request body and headers
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        // Make a request to Keycloak to obtain the access token
        ResponseEntity<Map> response = restTemplate.exchange(
                path_realm+"/protocol/openid-connect/token",
                HttpMethod.POST,
                requestEntity,
                Map.class
        );

        // Process the response from Keycloak and return an appropriate response
        if (response.getStatusCode().is2xxSuccessful()) {
            // Successful login
            Map<String, Object> responseBody = response.getBody();
            return ResponseEntity.ok(responseBody);  //Si l'authentification est réussite ell retourne le tocke dans la réponse
        } else {
            // Login failed
            return ResponseEntity.badRequest().body(null);
        }
    }
    @PutMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestParam("newPassword") String newPassword,
                                           @RequestParam("userId") String userId) {

        // Create the request body with the new password
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("type", "password");
        requestBody.put("value", newPassword);
        requestBody.put("temporary", false);

        // Create the headers for the request
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

        // Create the HTTP entity with the request body and headers
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        // Build the URL with the user ID
        String url = String.format(path_realm+"/users/%s/reset-password", userId);

        // Make a PUT request to the Keycloak API to reset the password
        ResponseEntity<Void> response = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                Void.class
        );

        // Process the response from Keycloak and return an appropriate response
        if (response.getStatusCode().is2xxSuccessful()) {
            // Password reset successful
            return ResponseEntity.ok().build();
        } else {
            // Password reset failed
            return ResponseEntity.badRequest().build();
        }
    }



}
