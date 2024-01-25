package com.practice.studentManagementSystem.controller;

import com.practice.studentManagementSystem.business.abstracts.StudentService;
import com.practice.studentManagementSystem.business.requests.CreateStudentRequest;
import com.practice.studentManagementSystem.business.requests.DeleteStudentRequest;
import com.practice.studentManagementSystem.business.requests.UpdateStudentRequest;
import com.practice.studentManagementSystem.business.responses.GetAllStudentResponse;
import com.practice.studentManagementSystem.business.responses.GetStudentByIdResponse;
import com.practice.studentManagementSystem.core.utilities.exceptions.BusinessException;
import com.practice.studentManagementSystem.core.utilities.exceptions.ProblemDetails;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/students")
@RestController
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;


    @GetMapping()
    public List<GetAllStudentResponse> getAll(){
        return this.studentService.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateStudentRequest createStudentRequest){
        this.studentService.add(createStudentRequest);

    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetails handleBusinessException(BusinessException ex) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(ex.getMessage());
        return problemDetails;
    }
    @PutMapping
    public void update(UpdateStudentRequest updateStudentRequest){
        this.studentService.update(updateStudentRequest);
    }

    @DeleteMapping
    public void delete(DeleteStudentRequest deleteStudentRequest){
        this.studentService.delete(deleteStudentRequest);
    }

    @GetMapping("/{id}")
    public GetStudentByIdResponse getStudentByIdResponse(@PathVariable  int id){
        return this.studentService.getStudentById(id);
    }
}
