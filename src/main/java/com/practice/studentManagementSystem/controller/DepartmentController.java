package com.practice.studentManagementSystem.controller;

import com.practice.studentManagementSystem.business.abstracts.DepartmentService;
import com.practice.studentManagementSystem.business.requests.CreateDepartmentRequest;
import com.practice.studentManagementSystem.business.responses.GetAllDepartmentResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;
    @GetMapping
    public List<GetAllDepartmentResponse> getAll(){
        return this.departmentService.getAll();
    }

    @PostMapping
    public void add(CreateDepartmentRequest createDepartmentRequest){
        this.departmentService.add(createDepartmentRequest);
    }
}
