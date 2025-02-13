package org.jsp.College_Directory_Application.entity;

import java.time.LocalTime;

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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacultyProfile {
	@Id
	private int id;
	@MapsId
	@OneToOne
	private User user;
	private String photo;
	@ManyToOne
	private Department department;
	private LocalTime officeHours;

}
