package com.boot.ser;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.boot.entity.Counselor;
import com.boot.repo.CounselorRepo;

@Service
public class CounselorServiceImpl implements CounselorService {

	@Autowired
	private CounselorRepo repo;
	@Autowired
	private JavaMailSender sender;

	@Override
	public void mailSending(String email, String pwd) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(email);
		sm.setSubject(" Password Recovery");
		sm.setText("Your Password is " + pwd);
		sender.send(sm);
	}

	@Override
	public String saveCounsellor(Counselor con) {
		Optional<Counselor> byEmail = repo.findByEmail(con.getEmail());
		if (byEmail.isPresent()) {
			return "EMAIL should be unique";
		}
		Counselor savedCounsellor = repo.save(con);
		if (savedCounsellor.getCid() != null) {
			return "Registration Success, please Log-IN";
		} else {
			return "Registration FAIL";
		}
	}

	@Override
	public Optional<Counselor> loginCheck(String email) {
		return repo.findByEmail(email);
	}

}
