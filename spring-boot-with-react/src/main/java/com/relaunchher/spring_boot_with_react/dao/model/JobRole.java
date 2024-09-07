package com.relaunchher.spring_boot_with_react.dao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_roles")
public class JobRole {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id", nullable = false)
  private Long userId;

  @Column(name = "job_role", nullable = false)
  private String jobRole;

  @Column(name = "description", nullable = false)
  private String description;

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public Long getUserId() {
    return userId;
  }

  public String getJobRole() {
    return jobRole;
  }

  public String getDescription() {
    return description;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public void setJobRole(String jobRole) {
    this.jobRole = jobRole;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "JobRole{" +
        "id=" + id +
        ", userId=" + userId +
        ", jobRole='" + jobRole + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
