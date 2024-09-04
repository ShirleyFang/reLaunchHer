package com.relaunchher.spring_boot_with_react.controller;

import com.relaunchher.spring_boot_with_react.dao.ApiResponse;
import com.relaunchher.spring_boot_with_react.dao.model.SelectionData;
import com.relaunchher.spring_boot_with_react.dao.model.User;
import com.relaunchher.spring_boot_with_react.service.LearningPathService;
import com.relaunchher.spring_boot_with_react.service.SelectionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping
public class SelectionDataController {
  private LearningPathController learningPathController;

//  @Autowired
//  private SelectionDataService selectionDataService;

//  @GetMapping("/about")
//  public ApiResponse aboutController() {
//    ApiResponse apiResponse = new ApiResponse();
//    apiResponse.setMessage("Welcome to selection data");
//    apiResponse.setStatus(true);
//    return apiResponse;
//  }
  private LearningPathService learningPathService;

  @Autowired
  public SelectionDataController(LearningPathService learningPathService) {
    this.learningPathService = learningPathService;
  }

  @PostMapping("/about")
  public ResponseEntity<String> createSelection(@RequestBody SelectionData selectionData) {
    String serviceResponse = learningPathService.processLearningPathPrompt(selectionData);

    System.out.println("Received data: " + selectionData);

    // Return the response from the service method
    return ResponseEntity.ok(serviceResponse);
  }

//  @GetMapping("/about/response")
//  public  getUserById(@PathVariable Long id) {
//    return userService.getReferenceById(id);
//  }
}

