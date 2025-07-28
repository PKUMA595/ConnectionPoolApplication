package com.piyush.cp.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piyush.cp.model.Student;
import com.piyush.cp.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping
	public String saveStudent(@RequestBody Student student) {
		try {
			studentRepository.saveStudent(student);
			return "Student Saved Successfully";
		} catch (Exception e) {
			return "Error : "+ e.getMessage();
		}
	}
	
	@GetMapping
	public List<Student> getStudents() throws InterruptedException, SQLException{
		return studentRepository.findAll();
	}

}
