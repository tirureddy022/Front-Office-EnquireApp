package com.boot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.entity.Counselor;
import com.boot.ser.CounselorService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CounselorController {

	@Autowired
	private CounselorService ser;
	@Autowired
	private HttpSession session;

	@GetMapping("/login")
	public String showCounsellorLogin(Model model) {
		model.addAttribute("counselor", new Counselor());
		return "login";
	}

	@GetMapping("/reg")
	public String showCounsellorRegForm(Model model) {
		model.addAttribute("counselor", new Counselor());
		return "reg";
	}

	@PostMapping("/save")
	public String handleRegistration(Counselor c, Model model) {
		String saveCounsellor = ser.saveCounsellor(c);
		model.addAttribute("msg", saveCounsellor);

		if (saveCounsellor.equals("Registration Success, please Log-IN")) {
			return "login";
		} else {
			return "reg";
		}
	}

	@PostMapping("/validate")
	public String validateCounselor(Counselor c, Model model) {
		Optional<Counselor> con = ser.loginCheck(c.getEmail());
		if (con.isPresent() && con.get().getPwd().equals(c.getPwd())) {
			session.setAttribute("user", con.get());
			return "redirect:/dashboard";
		} else {
			model.addAttribute("status", "Invalid Credentials");
			return "login";
		}

	}

	@GetMapping("/forgot")
	public String showForgotForm() {
		return "forgotPwd";
	}

	@PostMapping("/forgot")
	public String forgotPassword(@RequestParam("email") String email, Model model) {
		Optional<Counselor> con = ser.loginCheck(email);
		if (con.isPresent()) {
			String pwd = con.get().getPwd();
			ser.mailSending(email, pwd);
			model.addAttribute("msg", "Password Sent your mail");
			return "forgotPwd";
		} else {
			model.addAttribute("msg", "Email not found");
			return "forgotPwd";
		}
	}

	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/login";
	}
}
