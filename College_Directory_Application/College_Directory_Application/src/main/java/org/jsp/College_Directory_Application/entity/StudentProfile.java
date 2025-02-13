package org.jsp.College_Directory_Application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class StudentProfile {
	@Id
	private int id;
	@OneToOne
	@MapsId  //It maps the unique userId to student id(no need to generate id)
	private User user;
	private String photo;
	private String year;
	@ManyToOne
	private Department department;

}
