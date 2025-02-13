package org.jsp.College_Directory_Application.service;

import org.jsp.College_Directory_Application.dto.AuthCred;
import org.jsp.College_Directory_Application.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<?> saveUser(User user);

	ResponseEntity<?> findUserById(int id);

	ResponseEntity<?> findAllUsers();

	ResponseEntity<?> findByUsernameAndPassword(AuthCred authCred);

	ResponseEntity<?> deleteByUserId(int id);

}
