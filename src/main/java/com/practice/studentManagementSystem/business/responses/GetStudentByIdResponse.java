package com.practice.studentManagementSystem.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetStudentByIdResponse {
    private int id;
    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String studentNumber;

    private String departmentName;
}
