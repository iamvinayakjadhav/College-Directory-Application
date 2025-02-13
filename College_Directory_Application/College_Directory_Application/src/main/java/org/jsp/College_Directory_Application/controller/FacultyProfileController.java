package org.jsp.College_Directory_Application.controller;

import org.jsp.College_Directory_Application.entity.FacultyProfile;
import org.jsp.College_Directory_Application.service.FacultyProfileService;
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
@RequestMapping("/facultyProfile")
public class FacultyProfileController {
	@Autowired
	private FacultyProfileService service;
	
	@PostMapping("/{uid}")
	public ResponseEntity<?> saveFacultyprofile(@PathVariable int uid,@RequestBody FacultyProfile facultyProfile){
		return service.saveFacultyprofile(uid,facultyProfile);
		
	}
	@GetMapping("/{fid}")
	public ResponseEntity<?> findFacultyprofileById(@PathVariable int fid){
		return service.findFacultyprofileById(fid);
	}
	@GetMapping
	public ResponseEntity<?> findAllFacultyprofiles(){
		return service.findAllFacultyprofiles();
	}
	@PostMapping("/uploadPhoto/{fid}")
	public ResponseEntity<?> uploadPhototoFacultyprofile(@PathVariable int fid,@RequestParam MultipartFile file){
		return service.uploadPhototoFacultyprofile(fid,file);
	}
	@PatchMapping("/assignDepatmentId/{did}/{fid}")
	public ResponseEntity<?> assignDepatmenttoFaculty(@PathVariable int did,@PathVariable int fid){
		return service.assignDepatmenttoFaculty(did,fid);
	}

}
