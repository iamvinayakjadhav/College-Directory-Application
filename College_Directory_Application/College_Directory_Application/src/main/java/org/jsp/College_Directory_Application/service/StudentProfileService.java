package org.jsp.College_Directory_Application.service;

import org.jsp.College_Directory_Application.entity.StudentProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface StudentProfileService {

	ResponseEntity<?> saveStudentProfile(StudentProfile studentProfile, int uid);

	ResponseEntity<?> assignDepartmentToStudentProfile(int sid, int did);

	ResponseEntity<?> findStudentProfileById(int sid);

	ResponseEntity<?> findAllstudentProfiles();

	ResponseEntity<?> setYeartoStudentprofile(int id, String year);

	ResponseEntity<?> uploadPhoto(int sid, MultipartFile file);

}
