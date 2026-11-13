package com.empmngmt.repository;

import com.empmngmt.dto.EmpResponseDTO;
import com.empmngmt.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findByDepartment(String department);
}
