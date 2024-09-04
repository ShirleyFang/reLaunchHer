package com.relaunchher.spring_boot_with_react.service;

import com.relaunchher.spring_boot_with_react.dao.model.LearningPathPrompt;
import com.relaunchher.spring_boot_with_react.dao.model.SelectionData;

public interface LearningPathService {

  String processLearningPathPrompt(LearningPathPrompt learningPathPrompt);
  public String processLearningPathPrompt(SelectionData learningPathPrompt);
}
