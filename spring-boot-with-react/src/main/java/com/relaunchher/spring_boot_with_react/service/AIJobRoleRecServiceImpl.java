package com.relaunchher.spring_boot_with_react.service;

import com.relaunchher.spring_boot_with_react.dao.model.JobRole;
import com.relaunchher.spring_boot_with_react.dao.model.JobRoleRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AIJobRoleRecServiceImpl implements AIJobRoleRecService {

  private final OpenAiChatModel openAiChatModel;
  private final JobRoleRepository jobRoleRepository;

  @Autowired
  public AIJobRoleRecServiceImpl(OpenAiChatModel openAiChatModel, JobRoleRepository jobRoleRepository) {
    this.openAiChatModel = openAiChatModel;
    this.jobRoleRepository = jobRoleRepository;
  }

  @Override
  public List<JobRole> generateJobRoleRecommendation(String skills, String interests, Long userId) {
    String promptMessage = "You are a career job role suggestion engine that helps housewives generate ideas" +
        " for how to go back into the workforce. Based on these skills: " + skills +
        " and interests: " + interests + ", suggest 5 job roles in tech by incorporating each skill and interest." +
        " Provide the response strictly in the following format '#. Job Role: XXX. Description: XXX.'.";
    ChatResponse response = openAiChatModel.call(new Prompt(promptMessage));

    // Extract the message content from the response
    if (response != null && response.getResults() != null && !response.getResults().isEmpty()) {
      String aiContent = response.getResults().get(0).getOutput().getContent();
      List<JobRole> jobRoles = parseJobRoleRecommendations(aiContent, userId);

      // Save all job roles in the database
      jobRoleRepository.saveAll(jobRoles);  // Save all job roles at once
      System.out.println(aiContent);
      return jobRoles;
    } else {
      return new ArrayList<>(); // Return an empty list if no response received
    }
  }

  // Method to parse and create JobRole objects
  private List<JobRole> parseJobRoleRecommendations(String aiContent, Long userId) {
    List<JobRole> recommendations = new ArrayList<>();
    // Pattern to match job roles and descriptions
    Pattern pattern = Pattern.compile(
        "(\\d+)\\.\\s*Job Role:\\s*([^\\.]+?)\\.\\s*Description:\\s*([^\\d]+)",
        Pattern.MULTILINE
    );
    Matcher matcher = pattern.matcher(aiContent);

    // Iterate over each match and add it to the list
    while (matcher.find()) {
      String jobRoleName = matcher.group(2).trim(); // Capture job role
      String description = matcher.group(3).trim(); // Capture description

      // Create a new JobRole object for each parsed job role
      JobRole jobRole = new JobRole();
      jobRole.setUserId(userId);
      jobRole.setJobRole(jobRoleName);
      jobRole.setDescription(description);

      // Add jobRole to the list
      recommendations.add(jobRole);
    }

    System.out.println("Recommendations: " + recommendations);

    return recommendations;
  }
}
