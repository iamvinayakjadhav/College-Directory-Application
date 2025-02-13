package org.jsp.College_Directory_Application.controller;

import org.jsp.College_Directory_Application.entity.AdministratorProfile;
import org.jsp.College_Directory_Application.service.AdministratorProfileService;
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
@RequestMapping("adminstratorProfiles")
public class AdministratorProfileController {
	@Autowired
	private AdministratorProfileService service;
	
	@PostMapping("{uid}")
	private ResponseEntity<?> saveAdministratorProfile(@RequestBody AdministratorProfile administratorProfile,@PathVariable int uid){
		return service.saveAdministratorProfile(administratorProfile,uid);
		
	}
	@GetMapping("/{id}")
	private ResponseEntity<?> findAdministratorprofileById(@PathVariable int id){
		return service.findAdministratorprofileById(id);
	}
	@GetMapping
	private ResponseEntity<?> findAllAdminstratorProfile(){
		return service.findAllAdminstratorProfile();
	}
	@PostMapping("/uploadPhoto/{aid}")
	private ResponseEntity<?> uploadPhoto(@PathVariable int aid,@RequestParam MultipartFile file){
		return service.uploadPhoto(aid,file);
	}
	@PatchMapping("/{aid}/{did}")
	private ResponseEntity<?> assignDepartmentToCourse(@PathVariable int aid,@PathVariable int did){
		return service.assignDepartmentToCourse(aid,did);
	}

}
