package com.example.demo.studentreops;

import com.example.demo.studentModel.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepos extends JpaRepository<Student,Long> {

}
