package com.relaunchher.spring_boot_with_react.dao.repository;

import com.relaunchher.spring_boot_with_react.dao.model.SelectionData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelectionDataRepository extends JpaRepository<SelectionData, Long> {
  // Custom database queries can be defined here
}
