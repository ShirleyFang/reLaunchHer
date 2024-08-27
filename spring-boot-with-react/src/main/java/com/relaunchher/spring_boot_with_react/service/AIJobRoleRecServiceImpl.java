package com.relaunchher.spring_boot_with_react.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AIJobRoleRecServiceImpl implements AIJobRoleRecService {
  @Value("${openai.api.key}")
  private String OPENAI_API_KEY;

  private final RestTemplate restTemplate;

  public AIJobRoleRecServiceImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public String getJobRecommendations(String skills, String interests) {
    try {

      // OpenAI API endpoint
      String openAiUrl = "https://api.openai.com/v1/chat/completions";

      // Headers
      HttpHeaders headers = new HttpHeaders();
      headers.set("Authorization", "Bearer " + OPENAI_API_KEY);
      headers.setContentType(MediaType.APPLICATION_JSON);

      // Request body with the updated model
      Map<String, Object> body = new HashMap<>();
      body.put("model", "gpt-3.5-turbo"); // New model
      body.put("messages", List.of(
          Map.of("role", "system", "content", "You are a career recommendation engine."),
          Map.of("role", "user", "content", "I have the following skills: " + skills + ". My interests are: " + interests + ". Can you recommend some job roles?")
      ));

      HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

      // Execute the request
      ResponseEntity<String> response = restTemplate.postForEntity(openAiUrl, request, String.class);
      return response.getBody();

    } catch (Exception e) {
      throw new RuntimeException("Failed to retrieve career recommendations", e);
    }
  }


//  private String generatePrompt(String skills, String interests) {
//    return "Given the skills: " + skills + " and interests: " + interests + ", recommend suitable career roles.";
//  }

}
