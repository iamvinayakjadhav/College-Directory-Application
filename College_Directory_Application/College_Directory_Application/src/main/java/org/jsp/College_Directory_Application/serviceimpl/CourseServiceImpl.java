package org.jsp.College_Directory_Application.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.College_Directory_Application.dao.CourseDao;
import org.jsp.College_Directory_Application.dao.DepartmentDao;
import org.jsp.College_Directory_Application.dao.FacultyProfileDao;
import org.jsp.College_Directory_Application.entity.Course;
import org.jsp.College_Directory_Application.entity.Department;
import org.jsp.College_Directory_Application.entity.FacultyProfile;
import org.jsp.College_Directory_Application.responsestructure.ResponseStructure;
import org.jsp.College_Directory_Application.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao dao;

	@Autowired
	private FacultyProfileDao facultyprofiledao;

	@Autowired
	private DepartmentDao departmentdao;

	@Override
	public ResponseEntity saveCourse(Course course) {
		course = dao.saveCourse(course);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Course Saved Successfully").body(course).build());
	}

	@Override
	public ResponseEntity<?> findCourseById(int id) {
		Optional<Course> optional = dao.findCourseById(id);
		if (optional.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
					.message("Course By Id Found Successfully").body(optional.get()).build());
		} else {
			throw new RuntimeException("\"Course not found for ID: \" + id");
		}
	}

	@Override
	public ResponseEntity<?> findAllCourses() {
		List<Course> course = dao.findAllCourses();
		if (!course.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
					.message("All Course Found Successfully ").body(course).build());
		} else {
			throw new RuntimeException("No Course Present in DataBase");
		}

	}

	@Override
	public ResponseEntity<?> assignFacultyToCourse(int id, int fid) {
		Optional<FacultyProfile> optional1 = facultyprofiledao.findFacultyProfileById(fid);
		if (optional1.isEmpty()) {
			throw new RuntimeException("Invalid Faculty Id: " + fid);
		}
		Optional<Course> optional2 = dao.findCourseById(id);
		if (optional2.isEmpty()) {
			throw new RuntimeException("Invalid Course Id: " + id);
		}
		FacultyProfile facultyProfile = optional1.get();
		Course course = optional2.get();
		course.setFaculty(facultyProfile);
		course = dao.saveCourse(course);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Faculty Assigned Course Successfully").body(course).build());
	}

	@Override
	public ResponseEntity<?> deleteCourseById(int id) {
		Optional<Course> optional = dao.findCourseById(id);
		if (optional.isPresent()) {
			dao.deleteCourseById(id);
			return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
					.message("Course Deleted Successfully").body(null).build());
		} else {
			throw new RuntimeException("\"Course not found for ID: \" + id");
		}
	}

	@Override
	public ResponseEntity<?> assignDepartment(int cid, int did) {
		Optional<Course> optional1 = dao.findCourseById(cid);
		if (optional1.isEmpty()) {
			throw new RuntimeException("Invalid Course Id: " + cid);
		}
		Optional<Department> optional2 = departmentdao.findByDepartmentId(did);
		if (optional1.isEmpty()) {
			throw new RuntimeException("Invalid Department Id: " + did);
		}
		Department department = optional2.get();
		Course course = optional1.get();
		course.setDepartment(department);
		course = dao.saveCourse(course);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Department Assigned to  Course Successfully").body(department).build());
	}
}
