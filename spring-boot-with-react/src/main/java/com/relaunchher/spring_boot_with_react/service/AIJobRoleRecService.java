package com.relaunchher.spring_boot_with_react.service;

public interface AIJobRoleRecService {
  String generateJobRoleRecommendation(String skills, String interests, Long userID);
}

