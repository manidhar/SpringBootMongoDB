package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;

	public Student createStudent(Student student) {
		return studentRepo.save(student);
	}
	
	public Student getStudentById(String id) {
		return studentRepo.findById(id).get();
	}
	
	public List<Student> getStudents() {
		return studentRepo.findAll();
	}
	
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}
}
