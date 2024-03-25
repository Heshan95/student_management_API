package com.example.demo.api;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeAPI {

    private final EmployeeService service;

    public EmployeeAPI(EmployeeService service) {
        this.service = service;
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody EmployeeDTO obj) {
        service.save(obj);
    }

    @PutMapping(value = "/update")
    public void update(@RequestBody EmployeeDTO obj) {
        service.update(obj);
    }

    @GetMapping(value = "/get/{id:^EMP_[\\d]{3}$}")
    public EmployeeDTO search(@PathVariable String id) {
        EmployeeDTO search = service.search(id);
        return search;
    }

    @DeleteMapping(value = "/delete/{id:^EMP_[\\d]{3}$}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
