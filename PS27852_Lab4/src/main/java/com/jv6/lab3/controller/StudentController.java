package com.jv6.lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jv6.lab3.model.Student;
import jakarta.validation.Valid;

@Controller
public class StudentController {
	@RequestMapping("/student/form")
	public String form(Model model) {
		Student student = new Student();
		model.addAttribute("sv", student);
		return "student/form";
	}

	@RequestMapping("/student/save")
	public String save(Model model, @Valid @ModelAttribute("sv") Student student, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi sau:");
			return "student/form";
		}
		model.addAttribute("message", "Lưu thành công");
		return "student/success";
	}
}
