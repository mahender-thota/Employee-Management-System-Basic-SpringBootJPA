package com.empmngmt.controller;

import com.empmngmt.dto.EmpRequestDTO;
import com.empmngmt.dto.EmpResponseDTO;
import com.empmngmt.services.servicesImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping("/add")
    public EmpResponseDTO addEmployee(@RequestBody EmpRequestDTO requestDTO){
        return employeeService.addEmp(requestDTO);
    }

    @GetMapping
    public List<EmpResponseDTO> empList() {
        return employeeService.getAllEmp();
    }

    @GetMapping("/department/{name}")
    public List<EmpResponseDTO> departmentList(@PathVariable String name) {
        return employeeService.getByDepartmentName(name);
    }

    @GetMapping("/get/{id}")
    public EmpResponseDTO getById(@PathVariable int id){
        return employeeService.getById(id);
    }

    @PutMapping("/update/{id}")
    public EmpResponseDTO updateEmp(@PathVariable int id, @RequestBody EmpRequestDTO requestDTO) {
        return employeeService.updateEmp(id, requestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmp(id);
    }

}
