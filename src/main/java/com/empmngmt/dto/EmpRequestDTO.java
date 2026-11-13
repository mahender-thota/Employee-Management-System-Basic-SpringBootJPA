package com.empmngmt.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpRequestDTO {

    private String name;
    private String email;
    private String department;
    private double salary;
}
