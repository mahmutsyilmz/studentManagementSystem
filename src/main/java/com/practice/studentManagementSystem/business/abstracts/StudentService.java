package com.practice.studentManagementSystem.business.abstracts;

import com.practice.studentManagementSystem.business.requests.CreateStudentRequest;
import com.practice.studentManagementSystem.business.requests.DeleteStudentRequest;
import com.practice.studentManagementSystem.business.requests.UpdateStudentRequest;
import com.practice.studentManagementSystem.business.responses.GetAllStudentResponse;
import com.practice.studentManagementSystem.business.responses.GetStudentByIdResponse;
import com.practice.studentManagementSystem.entities.Student;

import java.util.List;

public interface StudentService {
    List<GetAllStudentResponse> getAll();
    void add(CreateStudentRequest createStudentRequest);
    void delete(DeleteStudentRequest deleteStudentRequest);

    void update(UpdateStudentRequest updateStudentRequest);

    GetStudentByIdResponse getStudentById(int id);
}
