package com.boot.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Counselor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	private String name;
	private String email;
	private String pwd;
	private String phno;

	@OneToMany(mappedBy = "counselor", cascade = CascadeType.ALL)
	private List<Student> students;

	@Override
	public String toString() {
		return "Counselor [cid=" + cid + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", phno=" + phno
				+ "]";
	}

}
