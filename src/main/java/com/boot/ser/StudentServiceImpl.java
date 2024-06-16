package com.boot.ser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.Student;
import com.boot.repo.StudentRepo;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo srepo;

	@Override
	public boolean saveStudent(Student s) {
		Student save = srepo.save(s);
		return save.getSid() != null;
	}

	public Integer totalEnquiriesOnCoun(Integer cid) {
		return srepo.totalEnquiries(cid);
	}

	@Override
	public Integer enrolledOnCon(Integer cid) {
		return srepo.enrolled(cid);
	}

	@Override
	public Integer lostOnCon(Integer cid) {
		return srepo.lost(cid);
	}

	@Override
	public List<Student> totalRecords(Integer cid) {
		return srepo.totalRecords(cid);
	}
}
