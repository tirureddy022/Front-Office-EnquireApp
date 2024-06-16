package com.boot.ser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.Course;
import com.boot.repo.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepo crepo;

	@Override
	public List<Course> allCourses() {
		return crepo.findAll();
	}
}
