package com.relaunchher.spring_boot_with_react.controller;

import com.relaunchher.spring_boot_with_react.service.AIJobRoleRecServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobs")
public class AIJobRoleRecController {

  @Autowired
  private AIJobRoleRecServiceImpl openAiService;

  @PostMapping("/recommendations")
  public String getJobRecommendations(@RequestParam String skills, @RequestParam String interests) {
    return openAiService.getJobRecommendations(skills, interests);
  }
}
