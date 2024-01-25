package com.practice.studentManagementSystem.dataAccess;

import com.practice.studentManagementSystem.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
