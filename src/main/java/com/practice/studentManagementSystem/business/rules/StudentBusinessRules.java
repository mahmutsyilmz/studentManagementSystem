package com.practice.studentManagementSystem.business.rules;

import com.practice.studentManagementSystem.core.utilities.exceptions.BusinessException;
import com.practice.studentManagementSystem.dataAccess.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentBusinessRules {
    private StudentRepository studentRepository;

    public void checkIfStudentNumberExists(String studentNumber){
        boolean check = this.studentRepository.existsStudentByStudentNumber(studentNumber);
        if (check){
            throw new BusinessException("Student already exists!");
        }
    }


    public void checkIfStudentNumberSize(String studentNumber){
        if (studentNumber.length()!=11) {
            throw new BusinessException("Student number must be 11 characters long");
        }
        for (char c : studentNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new BusinessException("Student number must consist of digits onl,,y");
            }
        }
    }

    public void checkIfEmailExists(String email) {
        boolean check = this.studentRepository.existsStudentByEmail(email);
        if (check) {
            throw new BusinessException("Student with this email already exists!");
        }
    }

    public void checkIfPhoneNumberExists(String phoneNumber) {
        boolean check = this.studentRepository.existsStudentByPhoneNumber(phoneNumber);
        if (check) {
            throw new BusinessException("Student with this phone number already exists!");
        }
    }

    public void checkPhoneNumberFormat(String phoneNumber) {
        if (phoneNumber.length() != 11) {
            throw new BusinessException("Phone number must be 11 characters long");
        }
        for (char c : phoneNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new BusinessException("Phone number must consist of digits only");
            }
        }
    }
}
