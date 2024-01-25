package com.practice.studentManagementSystem.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStudentRequest {
    private int id;

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String studentNumber;

    private int departmentId;

}
