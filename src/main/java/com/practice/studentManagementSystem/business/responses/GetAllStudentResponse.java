package com.practice.studentManagementSystem.business.responses;

import com.practice.studentManagementSystem.entities.Department;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllStudentResponse {
    private int id;

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String studentNumber;

    private String departmentName;
}
