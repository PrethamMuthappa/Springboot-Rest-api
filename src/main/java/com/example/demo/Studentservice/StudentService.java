
package com.example.demo.Studentservice;

import com.example.demo.studentModel.Student;
import com.example.demo.studentreops.StudentRepos;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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


    @Transactional
    public void update(long id, String name, String email) {
        Student student= studentRepos.findById(id).orElseThrow(()-> new IllegalStateException("not exist"));

        if(name!=null && name.length()>0 && !Objects.equals(student.getName(),name)) {
            student.setName(name);
        }

        if(email!=null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student>optionalStudent=studentRepos.findStudentByEmail(email);
            if(optionalStudent.isPresent()){
                throw  new IllegalStateException("email areary preset");
            }
            student.setEmail(email);
        }
    }
}

