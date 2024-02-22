package com.example.demo.studentreops;


import com.example.demo.studentModel.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Studentconfig {


    @Bean
    CommandLineRunner commandLineRunner(StudentRepos repos) {

        return args -> {

           Student p= new Student(
                    "basheer",
                    "email.comp",
                    21,
                    21
            );


           Student j= new Student(
                    "jamal",
                    "e",
                    21,
                    299
            );

            repos.saveAll(List.of(p,j));
        };



    };


}

