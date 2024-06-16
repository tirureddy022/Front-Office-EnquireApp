package com.boot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	private String sname;
	private String contactNo;
	private String classMode;
	private String course;
	private String enqStatus;

	@ManyToOne
	@JoinColumn(name = "cid")
	private Counselor counselor;

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", contactNo=" + contactNo + ", classMode=" + classMode
				+ ", course=" + course + ", enqStatus=" + enqStatus + "]";
	}

}
