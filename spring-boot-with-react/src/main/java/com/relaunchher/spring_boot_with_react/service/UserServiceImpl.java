package com.relaunchher.spring_boot_with_react.service;

import com.relaunchher.spring_boot_with_react.dao.model.User;
import com.relaunchher.spring_boot_with_react.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public User getReferenceById(Long id) {
    return userRepository.findById(id).get();
  }
}
