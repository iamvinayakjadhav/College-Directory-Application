package org.jsp.College_Directory_Application.repository;

import java.util.List;

import org.jsp.College_Directory_Application.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
	@Query("select e from Enrollment e where e.course.id = ?1 ")
	List<Enrollment> findByCourse(int cid);
	

}
