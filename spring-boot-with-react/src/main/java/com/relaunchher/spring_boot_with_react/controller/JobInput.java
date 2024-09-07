package com.relaunchher.spring_boot_with_react.controller;

import java.util.List;

public class JobInput {
  List<String> skills;
  List<String> interests;

  public JobInput(List<String> skills, List<String> interests) {
    this.skills = skills;
    this.interests = interests;
  }

  public List<String> getSkills() {
    return skills;
  }

  public List<String> getInterests() {
    return interests;
  }

  @Override
  public String toString() {
    return "JobInput{" +
        "skills=" + skills +
        ", interests=" + interests +
        '}';
  }
}
