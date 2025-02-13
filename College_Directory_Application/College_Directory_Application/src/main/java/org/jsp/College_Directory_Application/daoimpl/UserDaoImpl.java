package org.jsp.College_Directory_Application.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.College_Directory_Application.dao.UserDao;
import org.jsp.College_Directory_Application.entity.User;
import org.jsp.College_Directory_Application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private UserRepository repo;

	@Override
	public User saveUser(User user) {
		return repo.save(user);
	}

	@Override
	public Optional<User> findUserById(int id) {
		return repo.findById(id);
	}

	@Override
	public List<User> findAllUsers() {
		return repo.findAll();
	}

	@Override
	public Optional<User> findByUsernameAndPassword(String username, String password) {
		return repo.findByUsernameAndPassword(username, password);
	}

	@Override
	public void deleteByUserId(int id) {
		repo.deleteById(id);
	}

}
