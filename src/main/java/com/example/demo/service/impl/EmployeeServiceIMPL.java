package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class EmployeeServiceIMPL implements EmployeeService {

    ArrayList<EmployeeDTO> list = new ArrayList<>();

    @Override
    public void save(EmployeeDTO obj) {
        for (EmployeeDTO employeeDTO : list) {
            if (employeeDTO.getId().equals(obj.getId())) {
                return;
            }
        }
        list.add(obj);
    }

    @Override
    public void update(EmployeeDTO obj) {
        for (EmployeeDTO employeeDTO : list) {
            if (employeeDTO.getId().equals(obj.getId())) {
                employeeDTO.setName(obj.getName());
                employeeDTO.setAge(obj.getAge());
                employeeDTO.setEmail(obj.getEmail());
            }
        }
    }

    @Override
    public EmployeeDTO search(String id) {
        for (EmployeeDTO employeeDTO : list) {
            if (employeeDTO.getId().equals(id)) {
                return employeeDTO;
            }
        }
        return null;
    }

    @Override
    public void delete(String id) {
        for (EmployeeDTO employeeDTO : list) {
            if (employeeDTO.getId().equals(id)) {
                list.remove(employeeDTO);
            }
        }
    }
}
