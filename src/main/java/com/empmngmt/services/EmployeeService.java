package com.empmngmt.services;

import com.empmngmt.dto.EmpRequestDTO;
import com.empmngmt.dto.EmpResponseDTO;
import com.empmngmt.services.servicesImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface EmployeeService {

    public EmpResponseDTO addEmp(EmpRequestDTO requestDTO);

    public List<EmpResponseDTO>  getAllEmp();

    public EmpResponseDTO getById(int id);

    public EmpResponseDTO updateEmp(int id , EmpRequestDTO requestDTO);

    public String deleteEmp(int id);

    public List<EmpResponseDTO> getByDepartmentName(String name);

}
