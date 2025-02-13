package org.jsp.College_Directory_Application.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.College_Directory_Application.dao.StudentProfileDao;
import org.jsp.College_Directory_Application.entity.StudentProfile;
import org.jsp.College_Directory_Application.repository.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentProfileDaoImpl implements StudentProfileDao {
	@Autowired
	private StudentProfileRepository repo;

	@Override
	public StudentProfile saveStudentProfile(StudentProfile studentProfile) {
		return repo.save(studentProfile);
	}

	@Override
	public Optional<StudentProfile> findStudentProfileById(int sid) {
		return repo.findById(sid);
	}

	@Override
	public List<StudentProfile> findAllstudentProfiles() {
		return repo.findAll();
	}

}
