package com.rest.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.demo.model.Student;
import com.rest.demo.model.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	List<Student> students;

	@PostConstruct
	public void loadStudents() {
		students = new ArrayList<>();

		students.add(new Student("sree", "lakshmi", "sree.lakshmi@l&t.com"));
		students.add(new Student("roopam", "dafade", "roopam.dafade@TT.com"));
		students.add(new Student("pooja", "salunke", "pooja.salunke@TT.com"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {

		loadStudents();
		return students;

	}
	
	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable("studentId") int id) {

		if(id>students.size()||id<0) {
			throw new StudentNotFoundException("Student  Id not found : " + id);
		}
		return students.get(id);

	}
}
