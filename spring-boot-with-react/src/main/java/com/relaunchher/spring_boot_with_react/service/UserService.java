package com.relaunchher.spring_boot_with_react.service;


import com.relaunchher.spring_boot_with_react.dao.model.User;

public interface UserService {
  User getReferenceById(Long id);
}
