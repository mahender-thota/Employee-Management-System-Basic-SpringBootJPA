package com.empmngmt.services.servicesImpl;

import com.empmngmt.dto.EmpRequestDTO;
import com.empmngmt.dto.EmpResponseDTO;
import com.empmngmt.model.Employee;
import com.empmngmt.repository.EmployeeRepository;
import com.empmngmt.services.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmpResponseDTO addEmp(EmpRequestDTO requestDTO) {
        Employee emp = new Employee();
        BeanUtils.copyProperties(requestDTO, emp);
        Employee save = employeeRepository.save(emp);
        EmpResponseDTO responseDTO = new EmpResponseDTO();
        BeanUtils.copyProperties(save, requestDTO);
        return responseDTO;
    }

    @Override
    public List<EmpResponseDTO> getAllEmp() {
        List<Employee> empList = employeeRepository.findAll();
        List<EmpResponseDTO> responseDTOList = new ArrayList<>();
        for (Employee emp : empList) {
            EmpResponseDTO responseDTO = new EmpResponseDTO();
            BeanUtils.copyProperties(emp, responseDTO);
            responseDTOList.add(responseDTO);
        }
        return responseDTOList;
    }

    @Override
    public List<EmpResponseDTO> getByDepartmentName(String name) {
        List<Employee> dept = employeeRepository.findByDepartment(name);
        List<EmpResponseDTO> responseDTOList = new ArrayList<>();
        for (Employee emp : dept) {
            EmpResponseDTO responseDTO = new EmpResponseDTO();
            BeanUtils.copyProperties(emp, responseDTO);
            responseDTOList.add(responseDTO);
        }
        return responseDTOList;
    }

    @Override
    public EmpResponseDTO getById(int id) {
        Employee employee = employeeRepository.findById(id).get();
        EmpResponseDTO responseDTO = new EmpResponseDTO();
        BeanUtils.copyProperties(employee, responseDTO);
        return responseDTO;
    }

    @Override
    public EmpResponseDTO updateEmp(int id, EmpRequestDTO requestDTO) {
        Employee employee = employeeRepository.findById(id).get();
        BeanUtils.copyProperties(requestDTO, employee);
        employeeRepository.save(employee);
        EmpResponseDTO responseDTO = new EmpResponseDTO();
        BeanUtils.copyProperties(employee, responseDTO);
        return responseDTO;
    }

    @Override
    public String deleteEmp(int id) {
        employeeRepository.deleteById(id);
        return "Employee Deleted";
    }


}
