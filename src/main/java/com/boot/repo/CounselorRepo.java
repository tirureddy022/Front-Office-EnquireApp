package com.boot.repo;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Counselor;

public interface CounselorRepo extends JpaRepository<Counselor, Serializable> {

	Optional<Counselor> findByEmail(String email);
}
