package org.jsp.College_Directory_Application.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.College_Directory_Application.entity.StudentProfile;

public interface StudentProfileDao {

	 StudentProfile saveStudentProfile(StudentProfile studentProfile);

	Optional<StudentProfile> findStudentProfileById(int sid);

	List<StudentProfile> findAllstudentProfiles();

	

}
