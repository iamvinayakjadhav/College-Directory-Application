package org.jsp.College_Directory_Application.service;

import org.jsp.College_Directory_Application.entity.AdministratorProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface AdministratorProfileService {

	ResponseEntity<?> saveAdministratorProfile(AdministratorProfile administratorProfile,int  uid);

	ResponseEntity<?> findAdministratorprofileById(int id);

	ResponseEntity<?> findAllAdminstratorProfile();
	
	ResponseEntity<?> uploadPhoto(int aid, MultipartFile file);

	ResponseEntity<?> assignDepartmentToCourse(int aid, int did);

}
