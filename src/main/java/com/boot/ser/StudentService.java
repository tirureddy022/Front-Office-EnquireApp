package com.boot.ser;

import java.util.List;

import com.boot.entity.Student;

public interface StudentService {

	boolean saveStudent(Student s);

	public Integer totalEnquiriesOnCoun(Integer cid);

	public Integer enrolledOnCon(Integer cid);

	public Integer lostOnCon(Integer cid);

	List<Student> totalRecords(Integer cid);
}
