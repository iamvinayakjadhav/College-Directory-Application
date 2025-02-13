package org.jsp.College_Directory_Application.repository;

import org.jsp.College_Directory_Application.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Integer> {

}
