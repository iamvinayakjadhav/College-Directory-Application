package org.jsp.College_Directory_Application.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.College_Directory_Application.dao.DepartmentDao;
import org.jsp.College_Directory_Application.entity.Department;
import org.jsp.College_Directory_Application.responsestructure.ResponseStructure;
import org.jsp.College_Directory_Application.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao dao;

	@Override
	public ResponseEntity saveDepartment(Department department) {
		department = dao.saveDepartment(department);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Department Saved Successfully").body(department).build());
	}

	@Override
	public ResponseEntity<?> findByDepartmentId(int id) {
		Optional<?> optional = dao.findByDepartmentId(id);
		if (optional.isEmpty()) {
			throw new RuntimeException("Unable to find Department of " + id);
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Department Found Successfully").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> findAllDepartments() {
		List<Department> department = dao.findAllDepartments();
		if (!department.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
					.message("All Departments Found Successfully").body(department).build());
		}
		throw new RuntimeException("No Department Found in DataBase");

	}

	@Override
	public ResponseEntity<?> deleteDepartmentById(int id) {
		Optional<Department> optional = dao.findByDepartmentId(id);
		if (optional.isPresent()) {
			dao.deleteDepartmentById(id);
			return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
					.message("Department of " + id + " Deleted Successfully").body("Deletion Successfull").build());
		}
		throw new RuntimeException("Invalid ID Unable to Delete");

	}
}
