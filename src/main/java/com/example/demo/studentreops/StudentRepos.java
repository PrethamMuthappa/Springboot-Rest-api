package com.example.demo.studentreops;

import com.example.demo.studentModel.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepos extends JpaRepository<Student,Long> {
    Optional<Student>findStudentByEmail(String email);
    @Query("SELECT s FROM Student s WHERE s.name LIKE ?1%")
  List<Student>findStudentByNameStartingWith(String findstudents);

}
