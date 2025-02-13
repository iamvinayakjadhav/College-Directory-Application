package org.jsp.College_Directory_Application.service;

import org.springframework.http.ResponseEntity;

public interface EnrollmentService {

	ResponseEntity<?> saveEnrollment(int sid, int cid);

	ResponseEntity<?> findEnrollmentByCourseId(int cid);

	ResponseEntity<?> findAllEnrollmentsByFacultyId(int fid);

}
