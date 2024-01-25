package com.practice.studentManagementSystem.dataAccess;

import com.practice.studentManagementSystem.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    boolean existsStudentByStudentNumber(String studentNumber);
    boolean existsStudentByEmail(String email);
    boolean existsStudentByPhoneNumber(String phoneNumber);

}
