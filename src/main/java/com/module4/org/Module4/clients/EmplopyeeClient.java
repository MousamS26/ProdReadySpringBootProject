package com.module4.org.Module4.clients;

import com.module4.org.Module4.dto.EmployeeDTO;

import java.util.List;

public interface EmplopyeeClient
{

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long EmployeeId);

    EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO);
}
