package org.jsp.College_Directory_Application.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.College_Directory_Application.dao.FacultyProfileDao;
import org.jsp.College_Directory_Application.entity.FacultyProfile;
import org.jsp.College_Directory_Application.repository.FacultyProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class FacultyProfileImpl implements FacultyProfileDao {
	@Autowired
	private FacultyProfileRepository repo;
 
	@Override
	public FacultyProfile saveFacultyProfile(FacultyProfile facultyProfile) {
		return repo.save(facultyProfile);
	}

	@Override
	public Optional<FacultyProfile> findFacultyProfileById(int fid) {
		return repo.findById(fid);
	}

	@Override
	public List<FacultyProfile> findAllFacultyprofiles() {
		return repo.findAll();
	}

}
