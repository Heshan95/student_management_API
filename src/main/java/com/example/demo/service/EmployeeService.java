package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;

public interface EmployeeService {
    public void save(EmployeeDTO obj);
    public void update(EmployeeDTO obj);
    public EmployeeDTO search(String id);
    public void delete(String id);
}
