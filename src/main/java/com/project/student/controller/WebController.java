package com.project.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.student.model.Student;
import com.project.student.service.StudentService;

@Controller
@RequestMapping("/students")
public class WebController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public String showStudentList(Model model) {
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("students", students);
		model.addAttribute("newStudent", new Student());
		return "students";
	}

	@GetMapping("/students/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("student", student);
		return "edit-student";
	}

	// Thêm student
	@PostMapping("/students/add")
	public String addStudent(@ModelAttribute("newStudent") @Validated Student student, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Lỗi");
			return "students";
		}
		studentService.createStudent(student);
		return "redirect:/students/students";
	}

	// update student
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute Student student) {
		studentService.updateStudent(id, student);
		return "redirect:/students/students";

	}

	// xóa student
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/students/students";
	}
}
