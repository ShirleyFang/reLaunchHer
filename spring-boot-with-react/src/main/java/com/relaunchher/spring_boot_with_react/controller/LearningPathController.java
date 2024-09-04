package com.relaunchher.spring_boot_with_react.controller;

import com.relaunchher.spring_boot_with_react.dao.model.LearningPathPrompt;
import com.relaunchher.spring_boot_with_react.dao.model.SelectionData;
import com.relaunchher.spring_boot_with_react.service.AILearningPathServiceImpl;
import com.relaunchher.spring_boot_with_react.service.LearningPathService;
import com.relaunchher.spring_boot_with_react.service.SelectionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LearningPathController {
  private final LearningPathService learningPathService;

  @Autowired
  public LearningPathController(LearningPathService learningPathService) {
    this.learningPathService = learningPathService;
  }

  @Autowired
  private SelectionDataService selectionDataService;

//  @PostMapping("/data")
//  public ResponseEntity<String> createLearningPathPrompt(
//      @RequestBody LearningPathPrompt learningPathPrompt) {
//    // Process the data here using a service method
//    learningPathService.processLearningPathPrompt(learningPathPrompt);
//
//    // Logging the received data
//    System.out.println("Received data: " + learningPathPrompt);
//
//    // Return a response entity
//    return ResponseEntity.ok("Data received and processed successfully");
//  }

  @PostMapping("/api")
  public ResponseEntity<String> createLearningPathPrompt(
      @RequestBody SelectionData selectionData) {
    // Process the data here using a service method
    learningPathService.processLearningPathPrompt(selectionData);

    // Logging the received data
    System.out.println("Received data: " + selectionData);

    // Return a response entity
    return ResponseEntity.ok("Data received and processed successfully");
  }
}
