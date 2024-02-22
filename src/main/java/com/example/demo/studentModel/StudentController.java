package com.example.demo.studentModel;


import com.example.demo.Studentservice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/v2/")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/names")
    public List<Student> getnames(){
        return studentService.getnames();
    }

    @PostMapping("/students{student}")
    public void registerstudent(@RequestBody Student student){
        studentService.addnewNames(student);
    }

}
