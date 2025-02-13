package org.jsp.College_Directory_Application.entity;
import org.jsp.College_Directory_Application.util.Role;
import org.jsp.College_Directory_Application.util.UserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true,nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	private String name;
	@Column(unique = true)
	private String email;
	@Column(unique = true,length = 10)
	private String phone;
	private int otp;
	@Enumerated(EnumType.STRING)
	private Role role;
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	

}
