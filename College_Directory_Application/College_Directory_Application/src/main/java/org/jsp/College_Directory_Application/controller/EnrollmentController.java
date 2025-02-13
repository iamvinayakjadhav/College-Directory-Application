package org.jsp.College_Directory_Application.controller;

import org.jsp.College_Directory_Application.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
	@Autowired
	private EnrollmentService service;

	@PostMapping("/{sid}/{cid}")
	public ResponseEntity<?> saveEnrollment(@PathVariable int sid, @PathVariable int cid) {
		return service.saveEnrollment(sid, cid);
	}

	@GetMapping("/courses/{cid}")
	public ResponseEntity<?> findEnrollmentByCourseId(@PathVariable int cid) {
		return service.findEnrollmentByCourseId(cid);
	}

	@GetMapping("/faculty/{fid}")
	public ResponseEntity<?> findAllEnrollmentsByFacultyId(@PathVariable int fid) {
		return service.findAllEnrollmentsByFacultyId(fid);
	}

}
