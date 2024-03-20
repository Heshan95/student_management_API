package com.example.demo.api;

import com.example.demo.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeAPI {

    @PostMapping(value = "/save")
    public void save(@RequestBody EmployeeDTO obj) {
        System.out.println(obj);
    }

    @PutMapping(value = "/update")
    public void update(@RequestBody EmployeeDTO obj){
        System.out.println(obj);
    }

    @GetMapping(value = "/get/{id:^EMP_[\\d]{3}$}")
    public EmployeeDTO search(@PathVariable String id){
        return new EmployeeDTO("EMP_001", "EmployeeDTO one", 35, "employee@gmail.com");
    }

    @DeleteMapping(value = "/delete/{id:^EMP_[\\d]{3}$}")
    public void delete(@PathVariable String id){
        System.out.println(id);
    }
}
