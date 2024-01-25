package com.practice.studentManagementSystem.business.abstracts;

import com.practice.studentManagementSystem.business.requests.CreateDepartmentRequest;
import com.practice.studentManagementSystem.business.responses.GetAllDepartmentResponse;

import java.util.List;

public interface DepartmentService {
    List<GetAllDepartmentResponse> getAll();
    void add(CreateDepartmentRequest createDepartmentRequest);
}
