package org.jsp.College_Directory_Application.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.College_Directory_Application.entity.Course;

public interface CourseDao {

	Course saveCourse(Course course);

	Optional<Course> findCourseById(int id);

	List<Course> findAllCourses();

	void deleteCourseById(int id);

}
