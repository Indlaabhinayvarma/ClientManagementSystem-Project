package com.ihub.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ihub.www.model.EmployeeModel;

@Repository
public interface EmployeeRepository  extends JpaRepository<EmployeeModel,Long  >{

}
