package com.module4.org.Module4;

import com.module4.org.Module4.clients.EmplopyeeClient;
import com.module4.org.Module4.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class Module4ApplicationTests {

	@Autowired
	private EmplopyeeClient emplopyeeClient;

	@Test
	void getAllEmployees()
	{
		List<EmployeeDTO> employeeDTOList = emplopyeeClient.getAllEmployees();
		System.out.println(employeeDTOList);
	}

	@Test
	void getEmployeeByIdTest(){
		EmployeeDTO employeeDTO = emplopyeeClient.getEmployeeById(1L);
		System.out.println(employeeDTO);
	}

	@Test
	void createNewEmployee()
	{
		EmployeeDTO employeeDTO = new EmployeeDTO(null, "Mousam", "Mousam@gmail.com", 2, LocalDate.of(2020,12,23), "USER", true);
		EmployeeDTO savedEmployeeDTO = emplopyeeClient.createNewEmployee(employeeDTO);
		System.out.println(savedEmployeeDTO);
	}

}
