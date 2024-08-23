package com.relaunchher.spring_boot_with_react.controller;


import com.relaunchher.spring_boot_with_react.dao.model.User;
import com.relaunchher.spring_boot_with_react.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;
  @GetMapping("/user/{id}")
  public User getUserById(@PathVariable Long id) {
    return userService.getReferenceById(id);
  }
}
