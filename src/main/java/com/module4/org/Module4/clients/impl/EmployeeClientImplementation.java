package com.module4.org.Module4.clients.impl;

import com.module4.org.Module4.advice.ApiResponse;
import com.module4.org.Module4.clients.EmplopyeeClient;
import com.module4.org.Module4.dto.EmployeeDTO;
import com.module4.org.Module4.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImplementation implements EmplopyeeClient
{
    private final RestClient restClient;

    @Override
    //As this type is Parameterized(LIST) we have to use ParameterizedTypeReference
    public List<EmployeeDTO> getAllEmployees() {
        try{
            ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient.get()// Type of HTTP Request
                    .uri("employees")                                   // URI is appended after BASE URL
                    .retrieve()                                              // Data is retrieved
                    .body(new ParameterizedTypeReference<>() {               // Used to convert the data into particular type of object. Example List here
                    });

            assert employeeDTOList != null;
            return employeeDTOList.getData();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long EmployeeId) {
        try
        {
            ApiResponse<EmployeeDTO> employeeResponse = restClient.get()
                    .uri("employees/{employeeId}", EmployeeId)// We can pass any number of variables in this URI field
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });

            return employeeResponse.getData();
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        try {
            ApiResponse<EmployeeDTO> employeeDTOApiResponse = restClient.post()
                    .uri("employees")
                    .body(employeeDTO) //Accept Employee DTO as body
                    .retrieve()// Saved and Retrieve
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res)-> {      //Check for 4xx HTTP status codes
                        System.out.println("Error is:" + (new String(res.getBody().readAllBytes())));  //Printing error using res's body and reading all data
                        throw new ResourceNotFoundException("Could not Create new employee"); //Throwing exception
                    })
                    .body(new ParameterizedTypeReference<>()
                    {});
            return employeeDTOApiResponse.getData();
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
