package org.example.ps27952_vothanhtung.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.ps27952_vothanhtung.dao.EmployeeDAO;
import org.example.ps27952_vothanhtung.entity.Employee;
import org.example.ps27952_vothanhtung.entity.EmployeeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {


	private final EmployeeDAO dao;


	@RequestMapping("/employee/index")
	public String index(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		EmployeeMap map = dao.findAll();
		model.addAttribute("items", map);
		return "employee/index";
	}

	@RequestMapping("/employee/edit/{key}")
	public String edit(Model model, @PathVariable("key") String key) {
		model.addAttribute("key", key);
		Employee employee = dao.findByKey(key);
		model.addAttribute("employee", employee);
		EmployeeMap map = dao.findAll();
		model.addAttribute("items", map);
		return "employee/index";
	}
	@RequestMapping("/employee/create")
	public String create(@Valid @ModelAttribute("employee") Employee student,
						 BindingResult result, Model model) {
		if (result.hasErrors()) {
			// Nếu có lỗi, thêm các attribute vào model
			EmployeeMap map = dao.findAll();
			model.addAttribute("items", map); // Danh sách sinh viên
			return "employee/index";
		}

		if (dao.findByMaSV(student.getMaNV())) {
			// Thêm lỗi tùy chỉnh
			result.rejectValue("maNV", "error.employee", "Mã sinh viên đã tồn tại");
			EmployeeMap map = dao.findAll();
			model.addAttribute("items", map);
			return "employee/index";
		}

		dao.create(student); // Thêm sinh viên mới
		return "redirect:/employee/index";
	}

	@RequestMapping("/employee/update/{key}")
	public String update(@Valid @ModelAttribute("employee") Employee student,
						 BindingResult result, @PathVariable("key") String key,
						 Model model) {
		if (result.hasErrors()) {
			EmployeeMap map = dao.findAll();
			model.addAttribute("items", map); // Danh sách sinh viên
			model.addAttribute("key", key); // Key để sửa
			return "employee/index";
		}

		dao.update(key, student); // Cập nhật sinh viên
		return "redirect:/employee/index";
	}

	@RequestMapping("/employee/del/{key}")
	public String delete(@PathVariable("key") String key) {
		dao.delete(key);
		return "redirect:/employee/index";
	}
}
