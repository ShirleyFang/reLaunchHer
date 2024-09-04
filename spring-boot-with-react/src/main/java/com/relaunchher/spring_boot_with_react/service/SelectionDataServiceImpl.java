package com.relaunchher.spring_boot_with_react.service;

import com.relaunchher.spring_boot_with_react.dao.model.SelectionData;
import com.relaunchher.spring_boot_with_react.dao.repository.SelectionDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectionDataServiceImpl implements SelectionDataService{
  @Autowired
  private SelectionDataRepository repository;

  @Override
  public SelectionData createSelectionData(SelectionData selectionData) {
    return repository.save(selectionData);
  }
}
