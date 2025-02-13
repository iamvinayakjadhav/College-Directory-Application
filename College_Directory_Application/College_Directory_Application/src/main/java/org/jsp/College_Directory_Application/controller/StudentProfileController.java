package org.jsp.College_Directory_Application.controller;

import org.jsp.College_Directory_Application.entity.StudentProfile;
import org.jsp.College_Directory_Application.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value="/studentProfiles")
public class StudentProfileController {
	@Autowired
	private StudentProfileService service;
	
	@PostMapping("/{uid}")
	public ResponseEntity<?> saveStudentProfile(@RequestBody StudentProfile studentProfile, @PathVariable int uid){
		return service.saveStudentProfile(studentProfile,uid);
	}
	@PatchMapping("/{sid}/{did}")
	public ResponseEntity<?> assignDepartmentToStudentProfile(@PathVariable int sid,@PathVariable int did){
		return service.assignDepartmentToStudentProfile(sid,did);
	}
	@GetMapping("{sid}")
	public ResponseEntity<?> findStudentProfileById( @PathVariable int sid){
		return service.findStudentProfileById(sid);
	}
	@GetMapping
	public ResponseEntity<?> findAllstudentProfiles(){
		return service.findAllstudentProfiles();
	}
	@PatchMapping("/year/{id}/{year}")
	public ResponseEntity<?> setYeartoStudentprofile(@PathVariable int id,@PathVariable String year){
		return 	service.setYeartoStudentprofile(id,year);
		}
	@PostMapping("/profileImg/{sid}")
	public ResponseEntity<?> uploadPhoto(@PathVariable int sid,@RequestParam MultipartFile file){
		return service.uploadPhoto(sid,file);
	}
	
}

