package org.jsp.College_Directory_Application.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.College_Directory_Application.dao.AdministratorProfileDao;
import org.jsp.College_Directory_Application.entity.AdministratorProfile;
import org.jsp.College_Directory_Application.repository.AdministratorProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class AdministratorProfileDaoImpl implements AdministratorProfileDao {
	@Autowired
	private AdministratorProfileRepository repo;
	@Override
	public AdministratorProfile saveAdministratorProfile(AdministratorProfile administratorprofile) {
		return repo.save(administratorprofile);
	}
	@Override
	public Optional<AdministratorProfile> findAdministratorprofileById(int id) {
		return repo.findById(id);
	}
	@Override
	public List<AdministratorProfile> findAllAdminstratorProfile() {
		return repo.findAll();
	}

}
