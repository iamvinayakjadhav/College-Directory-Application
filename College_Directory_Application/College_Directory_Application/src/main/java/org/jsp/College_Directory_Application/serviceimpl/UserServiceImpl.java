package org.jsp.College_Directory_Application.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.College_Directory_Application.dao.AdministratorProfileDao;
import org.jsp.College_Directory_Application.dao.FacultyProfileDao;
import org.jsp.College_Directory_Application.dao.StudentProfileDao;
import org.jsp.College_Directory_Application.dao.UserDao;
import org.jsp.College_Directory_Application.dto.AuthCred;
import org.jsp.College_Directory_Application.entity.User;
import org.jsp.College_Directory_Application.responsestructure.ResponseStructure;
import org.jsp.College_Directory_Application.service.UserService;
import org.jsp.College_Directory_Application.util.OtpHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private OtpHelper otpHelper;

	@Autowired
	private UserDao dao;

	@Autowired
	private AdministratorProfileDao admin;

	@Autowired
	private FacultyProfileDao facultyprofile;

	@Autowired
	private StudentProfileDao studentprofile;

	@Override
	public ResponseEntity<?> saveUser(User user) {
		int otp = otpHelper.generateOTP();
		user.setOtp(otp);
		otpHelper.sendAccountCreationEmail(user);
		String photo = "";
		user = dao.saveUser(user);
//			if(user.getRole() == Role.ADMINISTRATOR)
//					admin.saveAdministratorProfile(AdministratorProfile.builder().id(user.getId())
//				.photo(photo).user(user).build());
//			else if (user.getRole() == Role.FACULTY)
//					facultyprofile.saveFacultyProfile(FacultyProfile.builder().id(user.getId())
//								.officeHours(LocalTime.of(8, 30)).build());
//			else
//				studentprofile.saveStudentProfile(StudentProfile.builder().id(user.getId()).photo(photo).build());

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("User Saved Successfully").body(user).build());
	}

	@Override
	public ResponseEntity<?> findUserById(int id) {
		Optional<User> optional = dao.findUserById(id);
		if (optional.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
					.message("User By Id Found Successfully").body(optional.get()).build());
		} else {
			throw new RuntimeException("\"User not found for ID: \" + id");
		}
	}

	@Override
	public ResponseEntity<?> findAllUsers() {
		List<User> course = dao.findAllUsers();
		if (!course.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
					.message("All Users Found Successfully ").body(course).build());
		} else {
			throw new RuntimeException("No User is  Present in DataBase");
		}
	}

	@Override
	public ResponseEntity<?> findByUsernameAndPassword(AuthCred authCred) {
		Optional<User> optional = dao.findByUsernameAndPassword(authCred.getUsername(), authCred.getPassword());
		if (!optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
					.message("Login Successfull").body(optional.get()).build());
		} else {
			throw new RuntimeException("Unable to login Invalid username or password");
		}

	}

	@Override
	public ResponseEntity<?> deleteByUserId(int id) {
		Optional<User> optional = dao.findUserById(id);
		if (optional.isEmpty()) {
			throw new RuntimeException("Unable to delete Invalid Userid");
		}
		dao.deleteByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("User By Id Found Successfully").body(optional.get()).build());
	}

}
