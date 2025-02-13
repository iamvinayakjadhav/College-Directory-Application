package org.jsp.College_Directory_Application.controller;

import org.jsp.College_Directory_Application.entity.Course;
import org.jsp.College_Directory_Application.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	private CourseService service;
	
	@PostMapping
	public ResponseEntity<?> saveCourse(@RequestBody Course course){
		return service.saveCourse(course);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findCourseById(@PathVariable int id){
		return service.findCourseById(id);
	}
	@GetMapping
	public ResponseEntity<?> findAllCourses(){
		return service.findAllCourses();
	}
	
	@PatchMapping(value = "/{cid}/{fid}")
	public ResponseEntity<?> assignFacultyToCourse(@PathVariable(name = "cid") int id,@PathVariable(name = "fid") int fid){
		return service.assignFacultyToCourse(id,fid);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteCourseById(@PathVariable int id){
		return service.deleteCourseById(id);
	}
	@PostMapping("/assignDepartment/{cid}/{did}")
	public ResponseEntity<?> assignDepartment(@PathVariable int cid,@PathVariable int did){
		return service.assignDepartment(cid,did);
	}
	

}
