package com.relaunchher.spring_boot_with_react.dao.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.System.Logger.Level;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LearningPathPrompt {
  // Define your own Level enum or use a different class name if Level is for educational or experience levels
  @JsonProperty("currentLevel")
  private StudyLevel currentLevel;

  @JsonProperty("specificInterests")
  private String specificInterests;

  @JsonProperty("learningGoal")
  private String learningGoal;

  @JsonProperty("timeCommitment")
  private String timeCommitment;

  @JsonProperty("studyType")
  private String studyType;

  @JsonProperty("financialResources")
  private String financialResources;

  @JsonProperty("city")
  private String city;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LearningPathPrompt learningPathPrompt = (LearningPathPrompt) o;
    return Objects.equals(currentLevel, learningPathPrompt.currentLevel) && Objects.equals(
        specificInterests, learningPathPrompt.specificInterests) && Objects.equals(learningGoal,
        learningPathPrompt.learningGoal) && Objects.equals(timeCommitment, learningPathPrompt.timeCommitment)
        && Objects.equals(studyType, learningPathPrompt.studyType) && Objects.equals(
        financialResources, learningPathPrompt.financialResources) && Objects.equals(city,
        learningPathPrompt.city);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentLevel, specificInterests, learningGoal, timeCommitment, studyType,
        financialResources, city);
  }

}
