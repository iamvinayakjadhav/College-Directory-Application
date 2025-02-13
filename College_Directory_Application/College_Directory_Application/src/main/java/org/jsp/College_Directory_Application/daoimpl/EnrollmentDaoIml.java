package org.jsp.College_Directory_Application.daoimpl;

import java.util.List;

import org.jsp.College_Directory_Application.dao.EnrollmentDao;
import org.jsp.College_Directory_Application.entity.Enrollment;
import org.jsp.College_Directory_Application.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class EnrollmentDaoIml implements EnrollmentDao {
	@Autowired
	private EnrollmentRepository repo;

	@Override
	public Enrollment saveEnrollment(Enrollment e) {
		return repo.save(e);
	}

	@Override
	public List<Enrollment> findAllEnrollments() {
		return repo.findAll();
	}

	@Override
	public List<Enrollment> findAllEnrollmentsByCourseId(int cid) {
		return repo.findByCourse(cid);
	}

	@Override
	public List<Enrollment> findAllEnrollments(int fid) {
		return repo.findAll();
	}

}
