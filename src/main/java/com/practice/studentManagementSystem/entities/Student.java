package com.practice.studentManagementSystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "student_name" , nullable = false)
    private String name;
    @Column(name = "student_surname" , nullable = false)
   private  String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    @Size(min = 11, max = 11, message = "Phone number must be 11 characters long")
    private String phoneNumber;
    @Column(name = "student_number" , unique = true , nullable = false)
    @Size(min = 11, max = 11, message = "Student number must be 11 characters long")
    private String studentNumber;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;




}
