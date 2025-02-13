package org.jsp.College_Directory_Application.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.College_Directory_Application.entity.Department;

public interface DepartmentDao {

	Department saveDepartment(Department department);

	Optional<Department> findByDepartmentId(int id);

	List<Department> findAllDepartments();

	void deleteDepartmentById(int id);

}
