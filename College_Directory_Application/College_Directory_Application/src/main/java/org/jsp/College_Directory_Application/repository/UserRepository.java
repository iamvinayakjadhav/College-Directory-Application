package org.jsp.College_Directory_Application.repository;

import java.util.Optional;

import org.jsp.College_Directory_Application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsernameAndPassword(String username,String password);

}
