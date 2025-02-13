package org.jsp.College_Directory_Application.service;

import org.jsp.College_Directory_Application.entity.Department;
import org.springframework.http.ResponseEntity;

public interface DepartmentService {
	ResponseEntity<?> saveDepartment(Department department);

	ResponseEntity<?> findByDepartmentId(int id);

	ResponseEntity<?> findAllDepartments();

	ResponseEntity<?> deleteDepartmentById(int id);
}
