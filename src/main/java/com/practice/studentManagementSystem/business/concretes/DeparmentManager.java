package com.practice.studentManagementSystem.business.concretes;

import com.practice.studentManagementSystem.business.abstracts.DepartmentService;
import com.practice.studentManagementSystem.business.requests.CreateDepartmentRequest;
import com.practice.studentManagementSystem.business.responses.GetAllDepartmentResponse;
import com.practice.studentManagementSystem.core.utilities.mappers.ModelMapperService;
import com.practice.studentManagementSystem.dataAccess.DepartmentRepository;
import com.practice.studentManagementSystem.entities.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeparmentManager implements DepartmentService {
    private final ModelMapperService modelMapperService;
    private final DepartmentRepository departmentRepository;
    @Override
    public List<GetAllDepartmentResponse> getAll() {
        List<Department> departments = this.departmentRepository.findAll();
        List<GetAllDepartmentResponse> responses = departments.stream()
                .map(department -> this.modelMapperService.forResponse()
                        .map(department,GetAllDepartmentResponse.class))
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public void add(CreateDepartmentRequest createDepartmentRequest) {
        Department department = this.modelMapperService.forRequest().map(createDepartmentRequest,Department.class);
        this.departmentRepository.save(department);

    }
}
