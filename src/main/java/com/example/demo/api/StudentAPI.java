package com.example.demo.api;

import com.example.demo.dto.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentAPI {
    @PostMapping("/save")
    public String SaveStudent(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age, @RequestHeader(value = "data") String data) {
        System.out.println(name + " " + age + " " + data);
        return "Student Saved!";
    }

    @PostMapping(value = "/{id:^STU_[\\d]{3}$}/{name}")
    public String pathVariable(@PathVariable String id, @PathVariable String name) {
        System.out.println(id + " " + name);
        return "OK";
    }

    @PostMapping(value = "/json", consumes = "application/json")
    public String json(@RequestBody Student student) {
//        System.out.println("Id : " + student.getId());
        System.out.println("Name : " + student.getName());
        System.out.println("Age : " + student.getAge());

        return "Json";
    }

    @PostMapping(value = "/jsonList", consumes = "application/json")
    public String catchJasonList(@RequestBody List<Student> list) {
        for (Student student : list) {
            System.out.println("-----------------------------------------");
            System.out.println("Name : " + student.getName());
            System.out.println("Age : " + student.getAge());
        }
        return "Json List";
    }

    @PostMapping(value = "/formData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFormData(@RequestPart(value = "test", required = false) String id, @RequestPart(value = "img") byte[] array, @RequestParam(value = "exe") String type) {
        // int intId = Integer.parseInt(id);
        System.out.println(array.length + " " + type);
        System.out.println(id);
        String property = System.getProperty("user.home");
        System.out.println(property);
        exportByByteArrayToFile(array, property+"/uploads/test." + type);
        return "Formdata";
    }

    public void exportByByteArrayToFile(byte[] byteArray, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(byteArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

