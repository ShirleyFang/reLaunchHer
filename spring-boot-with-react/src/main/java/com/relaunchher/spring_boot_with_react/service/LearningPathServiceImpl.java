package com.relaunchher.spring_boot_with_react.service;

import com.relaunchher.spring_boot_with_react.dao.model.LearningPathPrompt;
import com.relaunchher.spring_boot_with_react.dao.model.SelectionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearningPathServiceImpl implements LearningPathService {
  private static final String IN_PERSON = "in-person";
  private final AILearningPathService aiLearningPathService;

  @Autowired
  public LearningPathServiceImpl(AILearningPathService aiLearningPathService) {
    this.aiLearningPathService = aiLearningPathService;
  }

  private String generateLearningPathPrompt(LearningPathPrompt learningPathPrompt) {
    StringBuilder message = new StringBuilder();
    message.append("I am an ").append(learningPathPrompt.getCurrentLevel())
        .append(" aiming to become a ")
        .append(learningPathPrompt.getLearningGoal())
        .append(" with a specific interest in ")
        .append(learningPathPrompt.getSpecificInterests())
        .append("I am looking for part-time ");
    if (learningPathPrompt.getStudyType().replace("-", "")
        .equalsIgnoreCase(IN_PERSON)) {
      message.append(learningPathPrompt.getCity()).append("-based study resources. ");
    } else {
      message.append(learningPathPrompt.getStudyType()).append("study resources. ");
    }
    message.append("please generate a learning path with outside url-link");
    return message.toString();
  }

  private String generateLearningPathPrompt(SelectionData learningPathPrompt) {
    StringBuilder message = new StringBuilder();
    message.append("I am an ").append(learningPathPrompt.getOption1())
        .append("I am looking for ")
        .append(learningPathPrompt.getOption2())
        .append(learningPathPrompt.getOption3())
        .append(learningPathPrompt.getOption4())
        .append("study resources. ");
    message.append("please generate a learning path with outside url-link");
    return message.toString();
  }

  @Override
  public String processLearningPathPrompt(SelectionData learningPathPrompt) {
    String prompt = this.generateLearningPathPrompt(learningPathPrompt);
    return aiLearningPathService.generateResponse(prompt);
  }

  @Override
  public String processLearningPathPrompt(LearningPathPrompt learningPathPrompt) {
    String prompt = this.generateLearningPathPrompt(learningPathPrompt);
    return aiLearningPathService.generateResponse(prompt);
  }
}
