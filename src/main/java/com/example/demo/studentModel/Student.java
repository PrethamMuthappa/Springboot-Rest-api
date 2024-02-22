package com.example.demo.studentModel;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "student")
@Entity
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "dob")
    private Integer dob;

    @Column(name = "age")
    private Integer age;

    public Student(String name, String email, Integer dob, Integer age) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }
}


