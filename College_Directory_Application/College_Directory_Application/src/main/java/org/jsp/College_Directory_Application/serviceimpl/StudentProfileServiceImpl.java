package org.jsp.College_Directory_Application.serviceimpl;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.jsp.College_Directory_Application.dao.DepartmentDao;
import org.jsp.College_Directory_Application.dao.StudentProfileDao;
import org.jsp.College_Directory_Application.dao.UserDao;
import org.jsp.College_Directory_Application.entity.Department;
import org.jsp.College_Directory_Application.entity.StudentProfile;
import org.jsp.College_Directory_Application.entity.User;
import org.jsp.College_Directory_Application.responsestructure.ResponseStructure;
import org.jsp.College_Directory_Application.service.StudentProfileService;
import org.jsp.College_Directory_Application.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private StudentProfileDao studentProfiledao;
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public ResponseEntity<?> saveStudentProfile(StudentProfile studentProfile, int uid) {
		Optional<User> optional = userDao.findUserById(uid);
		if (optional.isEmpty())
			throw new RuntimeException("Invalid User Id Unable to save");
		User user = optional.get();
		if (user.getRole() != Role.STUDENT)
			throw new RuntimeException(
					"Invalid User Id student role doesn't matching found:" + user.getRole() + " but Required Student");
		studentProfile.setUser(user);
		studentProfile = studentProfiledao.saveStudentProfile(studentProfile);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Student Saved Successfully").body(studentProfile).build());
	}

	@Override
	public ResponseEntity<?> assignDepartmentToStudentProfile(int sid, int did) {
		Optional<StudentProfile> optional1 = studentProfiledao.findStudentProfileById(sid);
		if (optional1.isEmpty())
			throw new RuntimeException("Invalid Student profile Id unable to assign Department");
		Optional<Department> optional2 = departmentDao.findByDepartmentId(did);
		if (optional2.isEmpty())
			throw new RuntimeException("Invalid Department Id unable to assign Department");
		StudentProfile studentProfile = optional1.get();
		Department department = optional2.get();

		studentProfile.setDepartment(department);
		studentProfile = studentProfiledao.saveStudentProfile(studentProfile);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Department Assigned Successfully").body(studentProfile).build());

	}

	@Override
	public ResponseEntity<?> findStudentProfileById(int sid) {
		Optional<StudentProfile> optional = studentProfiledao.findStudentProfileById(sid);
		if (optional.isEmpty())
			throw new RuntimeException("Invalid Student profile Id unable to fetch");
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Department Assigned Successfully").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> findAllstudentProfiles() {
		List<StudentProfile> allStudentlist = studentProfiledao.findAllstudentProfiles();
		if (allStudentlist.isEmpty())
			throw new RuntimeException("No Student Profiles Present in DataBase");
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Department Assigned Successfully").body(allStudentlist).build());
	}

	@Override
	public ResponseEntity<?> setYeartoStudentprofile(int id, String year) {
		Optional<StudentProfile> optional = studentProfiledao.findStudentProfileById(id);
		if (optional.isEmpty())
			throw new RuntimeException("Invalid User Id No user found of id " + id + "");
		StudentProfile studentProfile = optional.get();
		studentProfile.setYear(year);
		studentProfile = studentProfiledao.saveStudentProfile(studentProfile);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Department Assigned Successfully").body(studentProfile).build());
	}

	@Override
	public ResponseEntity<?> uploadPhoto(int sid, MultipartFile file) {
		Optional<StudentProfile> optional = studentProfiledao.findStudentProfileById(sid);
		if (optional.isEmpty())
			throw new RuntimeException("Invalid User Id No user found of id " + sid + "");
		StudentProfile studentProfile = optional.get();
		String folder_path = "C:\\Users\\Vinayak Jadhav\\Desktop\\Uploaded_Images\\";
		String fileName = file.getOriginalFilename();
		String filePath = folder_path + fileName;
		File f = new File(filePath);
		try {
			file.transferTo(f);
		} catch (Exception e) {
			e.printStackTrace();
		}

		studentProfile.setPhoto(filePath);
		studentProfiledao.saveStudentProfile(studentProfile);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Photo Uploaded   Successfully").body(studentProfile).build());
	}

}
