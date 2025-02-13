package org.jsp.College_Directory_Application.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.College_Directory_Application.entity.User;

public interface UserDao {
	User saveUser(User user);

	Optional<User> findUserById(int id);

	List<User> findAllUsers();

	Optional<User> findByUsernameAndPassword(String username, String password);

	void deleteByUserId(int id);

}
