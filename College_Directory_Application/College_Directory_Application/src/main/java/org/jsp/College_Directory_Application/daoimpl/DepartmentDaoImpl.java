package org.jsp.College_Directory_Application.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.College_Directory_Application.dao.DepartmentDao;
import org.jsp.College_Directory_Application.entity.Department;
import org.jsp.College_Directory_Application.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	@Autowired
	private DepartmentRepository repo;

	@Override
	public Department saveDepartment(Department department) {

		return repo.save(department);
	}

	@Override
	public Optional<Department> findByDepartmentId(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Department> findAllDepartments() {
		return repo.findAll();
	}

	@Override
	public void deleteDepartmentById(int id) {
		repo.deleteById(id);
	}

}
