package org.jsp.College_Directory_Application.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.College_Directory_Application.entity.FacultyProfile;

public interface FacultyProfileDao {

	FacultyProfile saveFacultyProfile(FacultyProfile facultyProfile);

     Optional<FacultyProfile> findFacultyProfileById(int fid);

	List<FacultyProfile> findAllFacultyprofiles();

}
