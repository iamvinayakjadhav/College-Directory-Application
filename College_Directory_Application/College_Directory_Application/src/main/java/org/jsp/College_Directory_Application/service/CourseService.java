package org.jsp.College_Directory_Application.service;

import org.jsp.College_Directory_Application.entity.Course;
import org.springframework.http.ResponseEntity;

public interface CourseService {
	ResponseEntity<?> saveCourse(Course course);

	ResponseEntity<?> findCourseById(int id);

	ResponseEntity<?> findAllCourses();

	ResponseEntity<?> assignFacultyToCourse(int id, int fid);

	ResponseEntity<?> deleteCourseById(int id);

	ResponseEntity<?> assignDepartment(int cid, int did);
}
