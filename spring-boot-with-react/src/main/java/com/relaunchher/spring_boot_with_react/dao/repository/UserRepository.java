package com.relaunchher.spring_boot_with_react.dao.repository;

import com.relaunchher.spring_boot_with_react.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Override
  User getReferenceById(Long id);
}
