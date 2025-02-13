package org.jsp.College_Directory_Application.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.College_Directory_Application.entity.AdministratorProfile;

public interface AdministratorProfileDao {
	
	AdministratorProfile saveAdministratorProfile(AdministratorProfile administratorprofile);

	Optional<AdministratorProfile> findAdministratorprofileById(int id);

	List<AdministratorProfile> findAllAdminstratorProfile();

}
