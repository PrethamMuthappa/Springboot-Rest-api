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
                    "json vooresh",
                    "chaiths",
                    2002,
                   22

            );


           Student j= new Student(
                    "pretham",
                    "bachira@gmail.com",
                    2003,
                   21
            );

            repos.saveAll(List.of(p,j));
        };



    };


}

