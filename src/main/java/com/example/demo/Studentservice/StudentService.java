
package com.example.demo.Studentservice;

import com.example.demo.studentModel.Student;
import com.example.demo.studentreops.StudentRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepos studentRepos;

    @Autowired
    public StudentService(StudentRepos studentRepos) {
        this.studentRepos = studentRepos;
    }

    public List<Student> getnames(){
        return studentRepos.findAll();
    }
}

