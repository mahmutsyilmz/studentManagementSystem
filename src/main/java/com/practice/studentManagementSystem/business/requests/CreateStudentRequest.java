package com.practice.studentManagementSystem.business.requests;

import com.practice.studentManagementSystem.entities.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentRequest {
    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String studentNumber;

    private int departmentId;

}
