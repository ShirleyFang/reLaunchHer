package com.relaunchher.spring_boot_with_react.service;

import com.relaunchher.spring_boot_with_react.dao.model.JobRole;
import java.util.List;

public interface AIJobRoleRecService {
  List<JobRole> generateJobRoleRecommendation(String skills, String interests, Long userID);
}

