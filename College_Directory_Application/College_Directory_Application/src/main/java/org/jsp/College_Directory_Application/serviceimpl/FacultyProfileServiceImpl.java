package org.jsp.College_Directory_Application.serviceimpl;

import java.io.File;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.jsp.College_Directory_Application.dao.DepartmentDao;
import org.jsp.College_Directory_Application.dao.FacultyProfileDao;
import org.jsp.College_Directory_Application.dao.UserDao;
import org.jsp.College_Directory_Application.entity.Department;
import org.jsp.College_Directory_Application.entity.FacultyProfile;
import org.jsp.College_Directory_Application.entity.User;
import org.jsp.College_Directory_Application.responsestructure.ResponseStructure;
import org.jsp.College_Directory_Application.service.FacultyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FacultyProfileServiceImpl implements FacultyProfileService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private FacultyProfileDao dao;
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public ResponseEntity<?> saveFacultyprofile(int uid, FacultyProfile facultyProfile) {
		Optional<User> optional1 = userDao.findUserById(uid);
		if (optional1.isEmpty()) {
			throw new RuntimeException("Invalid User Id");
		}
		Optional<FacultyProfile> optional2 = dao.findFacultyProfileById(uid);
		if (optional1.isEmpty()) {
			throw new RuntimeException("Invalid Faculty Id");
		}
		User user = optional1.get();
		facultyProfile.setUser(user);
		facultyProfile.setOfficeHours(LocalTime.of(8, 30));
		dao.saveFacultyProfile(facultyProfile);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Faculty Profile created successfully").body(user).build());

	}

	@Override
	public ResponseEntity<?> findFacultyprofileById(int fid) {
		Optional<FacultyProfile> optional = dao.findFacultyProfileById(fid);
		if (optional.isEmpty()) {
			throw new RuntimeException("Inavlid User Id");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Faculty Profile Found Successfully").body(optional).build());
	}

	@Override
	public ResponseEntity<?> findAllFacultyprofiles() {
		List<FacultyProfile> faculty = dao.findAllFacultyprofiles();
		if (faculty.isEmpty()) {
			throw new RuntimeException("No Data Present In the DataBase");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Faculty Profile Found Successfully").body(faculty).build());
	}

	@Override
	public ResponseEntity<?> uploadPhototoFacultyprofile(int fid, MultipartFile file) {
		Optional<FacultyProfile> optional = dao.findFacultyProfileById(fid);
		if (optional.isEmpty()) {
			throw new RuntimeException("Inavlid User Id");
		}
		FacultyProfile faculty = optional.get();
		String folder_path = "C:\\Users\\Vinayak Jadhav\\Desktop\\Uploaded_Images";
		String fileName = file.getOriginalFilename();
		String filePath = folder_path + fileName;
		File f = new File(filePath);
		try {
			file.transferTo(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		faculty.setPhoto(filePath);
		dao.saveFacultyProfile(faculty);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Faculty Profile Uploaded Successfully").body(faculty).build());
	}

	@Override
	public ResponseEntity<?> assignDepatmenttoFaculty(int did, int fid) {
		Optional<Department> optional1 = departmentDao.findByDepartmentId(did);
		if (optional1.isEmpty()) {
			throw new RuntimeException("Inavlid Department  Id");
		}
		Optional<FacultyProfile> optional2 = dao.findFacultyProfileById(fid);
		if (optional1.isEmpty()) {
			throw new RuntimeException("Inavlid Faculty Progile   Id");
		}
		Department department = optional1.get();
		FacultyProfile faculty = optional2.get();
		faculty.setDepartment(department);
		dao.saveFacultyProfile(faculty);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Department Assigned to FacultyProfile Successfully").body(faculty).build());
	}

}
