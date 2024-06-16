package com.boot.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Serializable> {

}
