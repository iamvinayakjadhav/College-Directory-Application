package org.jsp.College_Directory_Application.serviceimpl;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.jsp.College_Directory_Application.dao.AdministratorProfileDao;
import org.jsp.College_Directory_Application.dao.DepartmentDao;
import org.jsp.College_Directory_Application.dao.UserDao;
import org.jsp.College_Directory_Application.entity.AdministratorProfile;
import org.jsp.College_Directory_Application.entity.Department;
import org.jsp.College_Directory_Application.entity.User;
import org.jsp.College_Directory_Application.responsestructure.ResponseStructure;
import org.jsp.College_Directory_Application.service.AdministratorProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AdministratorProfileServiceImpl implements AdministratorProfileService {
	@Autowired
	private AdministratorProfileDao dao;
	@Autowired
	private UserDao userdao;
	@Autowired
	private DepartmentDao dapartmentDao;

	@Override
	public ResponseEntity<?> saveAdministratorProfile(AdministratorProfile administratorProfile, int uid) {
		Optional<User> optional = userdao.findUserById(uid);
		User user = optional.get();
		if (optional.isEmpty()) {
			throw new RuntimeException("Invalid User Id ");
		}
		administratorProfile.setUser(user);
		administratorProfile = dao.saveAdministratorProfile(administratorProfile);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Admin Profile Saved Successfully ").body(administratorProfile).build());
	}

	@Override
	public ResponseEntity<?> findAdministratorprofileById(int id) {
		Optional<AdministratorProfile> optional = dao.findAdministratorprofileById(id);
		if (optional.isEmpty()) {
			throw new RuntimeException("Invalid AdministratorProfile Id ");
		}
		AdministratorProfile admin = optional.get();
		ResponseStructure response = ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Administrator Found Successfully").body(admin).build();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@Override
	public ResponseEntity<?> findAllAdminstratorProfile() {
		List<AdministratorProfile> allAdministratorProfile = dao.findAllAdminstratorProfile();
		if (allAdministratorProfile.isEmpty()) {
			throw new RuntimeException("No Data Present in Database ");
		}

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("All Administrator Fond SuccessFully").body(allAdministratorProfile).build());
	}

	@Override
	public ResponseEntity<?> uploadPhoto(int aid, MultipartFile file) {
		Optional<AdministratorProfile> optional = dao.findAdministratorprofileById(aid);
		if (optional.isEmpty()) {
			throw new RuntimeException("Invalid AdministratorProfile Id ");
		}
		AdministratorProfile admin = optional.get();
		String folder_path = "C:\\Users\\Vinayak Jadhav\\Desktop\\Uploaded_Images";
		String fileName = file.getOriginalFilename();
		String filePath = folder_path + fileName;
		File f = new File(filePath);
		try {
			file.transferTo(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		admin.setPhoto(filePath);
		dao.saveAdministratorProfile(admin);

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Admin Photo uploaded Successfully ").body(admin).build());
	}

	@Override
	public ResponseEntity<?> assignDepartmentToCourse(int aid, int did) {
		Optional<AdministratorProfile> optional1 = dao.findAdministratorprofileById(aid);
		if (optional1.isEmpty()) {
			throw new RuntimeException("Invalid AdministratorProfile Id ");
		}
		AdministratorProfile admin = optional1.get();
		Optional<Department> optional2 = dapartmentDao.findByDepartmentId(did);
		if (optional2.isEmpty()) {
			throw new RuntimeException("Invalid AdministratorProfile Id ");
		}
		Department department = optional2.get();
		admin.setDepartment(department);
		dao.saveAdministratorProfile(admin);
		ResponseStructure response = ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Depatment assigned Successfully").body(department).build();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
