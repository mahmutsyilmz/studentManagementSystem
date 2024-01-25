package com.practice.studentManagementSystem.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDepartmentResponse {
    private int id;
    private String name;
}
