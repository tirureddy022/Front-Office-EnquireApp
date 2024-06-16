package com.boot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boot.entity.Counselor;
import com.boot.entity.Student;
import com.boot.ser.CounselorService;
import com.boot.ser.CourseService;
import com.boot.ser.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

	@Autowired
	private HttpSession session;

	@Autowired
	private StudentService ser;
	@Autowired
	private CourseService cser;

	@Autowired
	private CounselorService cser1;

	@GetMapping("/dashboard")
	public String counselerDashBoard(Model model) {
		Counselor con = (Counselor) session.getAttribute("user");

		model.addAttribute("totalEnq", "Total Enquires : <br>" + ser.totalEnquiriesOnCoun(con.getCid()));
		model.addAttribute("enrolled", "Enrolled : <br>" + ser.enrolledOnCon(con.getCid()));
		model.addAttribute("lost", "Lost : <br> " + ser.lostOnCon(con.getCid()));

		return "conDashBoard";
	}

	@GetMapping("/student")
	public String showStudentForm(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("courses", cser.allCourses());
		return "student";
	}

	@PostMapping("/saveStudent")
	private String saveStudentEnquiry(Student student, Model model, RedirectAttributes redirectAttributes) {
		Counselor con = (Counselor) session.getAttribute("user");
		Optional<Counselor> counselor = cser1.loginCheck(con.getEmail());
		student.setCounselor(counselor.get());
		ser.saveStudent(student);
		redirectAttributes.addFlashAttribute("msg", "Enquiry added");

		return "redirect:student";
	}

	@GetMapping("/allEnq")
	public String viewRecords(Model model) {
		Counselor con = (Counselor) session.getAttribute("user");
		model.addAttribute("student", ser.totalRecords(con.getCid()));
		return "viewRecords";
	}

}
