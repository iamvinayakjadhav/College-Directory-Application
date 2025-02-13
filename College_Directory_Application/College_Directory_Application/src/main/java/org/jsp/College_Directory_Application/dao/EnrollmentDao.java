package org.jsp.College_Directory_Application.dao;

import java.util.List;

import org.jsp.College_Directory_Application.entity.Enrollment;

public interface EnrollmentDao {

	 Enrollment saveEnrollment(Enrollment e);

	List<Enrollment> findAllEnrollments();

	List<Enrollment> findAllEnrollmentsByCourseId(int cid);

	List<Enrollment> findAllEnrollments(int fid);

}
