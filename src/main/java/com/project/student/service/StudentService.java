package com.project.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.student.model.Student;
import com.project.student.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();

	}

	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);

	}

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	public Student updateStudent (Long id, Student updateStudent) {
		Student existingStudent = studentRepository.findById(id).orElse(null);
		if (existingStudent!=null) {
			existingStudent.setName(updateStudent.getName());
			existingStudent.setAddress(updateStudent.getAddress());
			existingStudent.setAge(updateStudent.getAge());
			return studentRepository.save(existingStudent);
		}
		return updateStudent;
		
	}
	public Student partialUpdateStudent(Long id, Student updateStudent) {
		Student existingStudent = studentRepository.findById(id).orElse(null);
		if (existingStudent != null) {
			if (existingStudent.getName() != null) {
				existingStudent.setName(updateStudent.getName());
			}
			if (existingStudent.getAddress() != null) {
				existingStudent.setAddress(updateStudent.getAddress());
			}
			if (existingStudent.getAge() > 0) {
				existingStudent.setAge(updateStudent.getAge());
			}
			return studentRepository.save(existingStudent);
		}
		return null;

	}

	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

}
