package org.jsp.College_Directory_Application.controller;

import org.jsp.College_Directory_Application.entity.Department;
import org.jsp.College_Directory_Application.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	@Autowired
	private DepartmentService service;
	
	@PostMapping
	public ResponseEntity<?> saveDepartment(@RequestBody Department department){
		 return service.saveDepartment(department);
	}
	@GetMapping("{id}")
	public ResponseEntity<?> findByDepartmentId(@PathVariable int id){
		return service.findByDepartmentId(id);
	}
	@GetMapping
	public ResponseEntity<?> findAllDepartments(){
		return service.findAllDepartments();
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteDepartmentById(@PathVariable int id){
		return service.deleteDepartmentById(id);
	}

}
