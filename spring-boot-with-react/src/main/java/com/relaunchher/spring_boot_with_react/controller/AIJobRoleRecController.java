package com.relaunchher.spring_boot_with_react.controller;

import com.relaunchher.spring_boot_with_react.dao.model.JobRole;
import com.relaunchher.spring_boot_with_react.service.AIJobRoleRecService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/job-recommendations")
public class AIJobRoleRecController {

  private final AIJobRoleRecService aiJobRoleRecService;

  @Autowired
  public AIJobRoleRecController(AIJobRoleRecService aiJobRoleRecService) {
    this.aiJobRoleRecService = aiJobRoleRecService;
  }

  @PostMapping
  public List<JobRole> generateJobRoleRecommendation(@RequestParam String skills, @RequestParam String interests, @RequestParam Long userId) {
    return aiJobRoleRecService.generateJobRoleRecommendation(skills, interests, userId);
  }
}
