//package com.project.student.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.project.student.model.Student;
//import com.project.student.service.StudentService;
//
//@RestController
//@RequestMapping("/students")
//public class StudentController {
//	@Autowired
//	private StudentService studentService;
//
//	@GetMapping
//	public List<Student> getAllStudents() {
//		return studentService.getAllStudents();
//	}
//
//	@GetMapping("/students")
//	public String showStudent(Model model) {
//		List<Student> students = studentService.getAllStudents();
//		model.addAttribute("students", students);
//		return "students";
//
//	}
//
//	@GetMapping("/{id}")
//	public Student getStudentById(Long id) {
//		return studentService.getStudentById(id);
//	}
//
//	@PostMapping
//	public Student createStudent(@RequestBody Student student) {
//		return studentService.createStudent(student);
//
//	}
//
//	@PutMapping("/{id}")
//	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
//		return studentService.updateStudent(id, student);
//
//	}
//
//	@PatchMapping("/{id}")
//	public Student partialUpdateStudent(@PathVariable Long id, @RequestBody Student student) {
//		return studentService.partialUpdateStudent(id, student);
//	}
//
//	@DeleteMapping("/{id}")
//	public void deleteStudent(Long id) {
//		studentService.deleteStudent(id);
//	}
//
//}
