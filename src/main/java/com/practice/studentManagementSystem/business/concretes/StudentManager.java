package com.practice.studentManagementSystem.business.concretes;

import com.practice.studentManagementSystem.business.abstracts.StudentService;
import com.practice.studentManagementSystem.business.requests.CreateStudentRequest;
import com.practice.studentManagementSystem.business.requests.DeleteStudentRequest;
import com.practice.studentManagementSystem.business.requests.UpdateStudentRequest;
import com.practice.studentManagementSystem.business.responses.GetAllStudentResponse;
import com.practice.studentManagementSystem.business.responses.GetStudentByIdResponse;
import com.practice.studentManagementSystem.business.rules.StudentBusinessRules;
import com.practice.studentManagementSystem.core.utilities.mappers.ModelMapperService;
import com.practice.studentManagementSystem.dataAccess.StudentRepository;
import com.practice.studentManagementSystem.entities.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class StudentManager implements StudentService {
    private final ModelMapperService modelMapperService;
    private final StudentRepository studentRepository;
    private final StudentBusinessRules studentBusinessRules;
    @Override
    public List<GetAllStudentResponse> getAll() {
        List<Student> students = studentRepository.findAll();
        List<GetAllStudentResponse> responses = students.stream()
                .map(student -> this.modelMapperService.forResponse()
                        .map(student, GetAllStudentResponse.class))
                .toList();

        return responses;
    }

    @Override
    public void add(CreateStudentRequest createStudentRequest) {
        this.studentBusinessRules.checkIfStudentNumberExists(createStudentRequest.getStudentNumber());
        this.studentBusinessRules.checkIfStudentNumberSize(createStudentRequest.getStudentNumber());
        this.studentBusinessRules.checkIfEmailExists(createStudentRequest.getEmail());
        this.studentBusinessRules.checkIfPhoneNumberExists(createStudentRequest.getPhoneNumber());
        this.studentBusinessRules.checkPhoneNumberFormat(createStudentRequest.getPhoneNumber());
        Student student = this.modelMapperService.forRequest().map(createStudentRequest,Student.class);



        this.studentRepository.save(student);
    }

    @Override
    public void delete(DeleteStudentRequest deleteStudentRequest) {
        Student student = this.modelMapperService.forRequest()
                .map(deleteStudentRequest,Student.class);
        this.studentRepository.delete(student);
    }

    @Override
    public void update(UpdateStudentRequest updateStudentRequest) {
        Student student = this.modelMapperService.forRequest().map(updateStudentRequest,Student.class);

        this.studentRepository.save(student);
    }

    @Override
    public GetStudentByIdResponse getStudentById(int id) {
        Student student = this.studentRepository.findById(id).orElseThrow();
        GetStudentByIdResponse getStudentByIdResponse = this.modelMapperService.forResponse()
                .map(student,GetStudentByIdResponse.class);
        return getStudentByIdResponse;
    }
}
