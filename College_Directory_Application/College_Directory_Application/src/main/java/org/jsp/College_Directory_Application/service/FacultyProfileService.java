package org.jsp.College_Directory_Application.service;

import org.jsp.College_Directory_Application.entity.FacultyProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FacultyProfileService {

	ResponseEntity<?> saveFacultyprofile(int uid, FacultyProfile facultyProfile);

	ResponseEntity<?> findFacultyprofileById(int fid);

	ResponseEntity<?> findAllFacultyprofiles();

	ResponseEntity<?> uploadPhototoFacultyprofile(int fid, MultipartFile file);

	ResponseEntity<?> assignDepatmenttoFaculty(int did, int fid);

}
