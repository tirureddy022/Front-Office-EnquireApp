package com.boot.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Serializable> {

	@Query(" FROM Student s WHERE s.counselor.cid = :cid")
	List<Student> totalRecords(@Param("cid") Integer cid);

	@Query("SELECT COUNT(*) FROM Student s WHERE s.counselor.cid = :cid")
	Integer totalEnquiries(@Param("cid") Integer cid);

	@Query("SELECT COUNT(*) FROM Student s WHERE s.counselor.cid = :cid AND s.enqStatus='enrolled' ")
	Integer enrolled(@Param("cid") Integer cid);

	@Query("SELECT COUNT(*) FROM Student s WHERE s.counselor.cid = :cid AND s.enqStatus='lost' ")
	Integer lost(@Param("cid") Integer cid);

//	@Query("SELECT s.sname, s.course, s.contactNo, s.enqStatus, s.classMode FROM Student s WHERE s.counselor.cid = :cid")
//	List<RecordsDashboard> allRecordsOnCon(@Param("cid") Integer cid);

}
