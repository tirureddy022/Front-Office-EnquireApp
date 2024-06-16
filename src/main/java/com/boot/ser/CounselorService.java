package com.boot.ser;

import java.util.Optional;

import com.boot.entity.Counselor;

public interface CounselorService {

	String saveCounsellor(Counselor con);

	Optional<Counselor> loginCheck(String email);

	void mailSending(String email, String pwd);

}
