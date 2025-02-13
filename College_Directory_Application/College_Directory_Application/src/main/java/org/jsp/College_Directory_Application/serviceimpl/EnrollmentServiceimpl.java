package org.jsp.College_Directory_Application.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.College_Directory_Application.dao.CourseDao;
import org.jsp.College_Directory_Application.dao.EnrollmentDao;
import org.jsp.College_Directory_Application.dao.StudentProfileDao;
import org.jsp.College_Directory_Application.entity.Course;
import org.jsp.College_Directory_Application.entity.Enrollment;
import org.jsp.College_Directory_Application.entity.StudentProfile;
import org.jsp.College_Directory_Application.responsestructure.ResponseStructure;
import org.jsp.College_Directory_Application.service.EnrollmentService;
import org.jsp.College_Directory_Application.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentServiceimpl implements EnrollmentService {
	@Autowired
	private EnrollmentDao enrollmentDao;

	@Autowired
	private StudentProfileDao studentProfiledao;

	@Autowired
	private CourseDao courseDao;

	@Override
	public ResponseEntity<?> saveEnrollment(int sid, int cid) {
		// There is no need to validate weather Student or not because we are using
		// direct student not user
		Optional<StudentProfile> optional1 = studentProfiledao.findStudentProfileById(sid);
		if (optional1.isEmpty())
			throw new RuntimeException("Invalid Student Id Unable To Enroll the Course");
		StudentProfile studentProfile = optional1.get();

		if (studentProfile.getUser().getRole() != Role.STUDENT)
			throw new RuntimeException(
					"Invalid Role Mismatch Expected Student instead of " + studentProfile.getUser().getRole());
		Optional<Course> optional2 = courseDao.findCourseById(cid);
		if (optional1.isEmpty())
			throw new RuntimeException("Invalid Student Id Unable To Enroll the Course");
		Course course = optional2.get();
		Enrollment e = Enrollment.builder().student(studentProfile).course(course).build();
		e = enrollmentDao.saveEnrollment(e);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Enrollment Successfully Completed").body(e).build());
	}

	@Override
	public ResponseEntity<?> findEnrollmentByCourseId(int cid) {
		List<Enrollment> enrollments = enrollmentDao.findAllEnrollmentsByCourseId(cid);
//		Optional<Course> optional = courseDao.findCourseById(cid);
//	List<Enrollment> Allenrollments =  enrollmentDao.findAllEnrollments();
//	List<Enrollment> filterEnrollments = new LinkedList<>();
//	for(Enrollment e : Allenrollments) {
//		if(e.getCourse().getId() == cid) {
//			filterEnrollments.add(e);
//		}
//	}
		if (enrollments.isEmpty())
			throw new RuntimeException("No Enrollments Found For The Course id " + cid);

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("All Enrollments of Course Id " + cid + " Found Successfully ").body(enrollments).build());
	}

	@Override
	public ResponseEntity<?> findAllEnrollmentsByFacultyId(int fid) {
		List<Enrollment> allEnroll = enrollmentDao.findAllEnrollments(fid);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("All Enrollments of Course Id " + fid + " Found Successfully ").body(allEnroll).build());
	}
}
