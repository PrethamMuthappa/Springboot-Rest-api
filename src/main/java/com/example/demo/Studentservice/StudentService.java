
package com.example.demo.Studentservice;

import com.example.demo.studentModel.Student;
import com.example.demo.studentreops.StudentRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void addnewNames(Student student) {
        Optional<Student> studentOptional=studentRepos.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email already taken");
        }
        studentRepos.save(student);
    }

    public List<Student> findc(String findstudents){

        List<Student>optionalStudent=studentRepos.findStudentByNameStartingWith(findstudents);
        if(optionalStudent.isEmpty()){
           throw new IllegalStateException("name not found");
        }
        return optionalStudent;

    }

    public void deleteid(long id) {
        boolean b=studentRepos.existsById(id);
        if(!b){
            throw new IllegalStateException("id does not exist");
        }
        studentRepos.deleteById(id);
    }
}

