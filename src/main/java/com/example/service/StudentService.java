package com.example.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	public String deleteStudent(String id) {
		studentRepo.deleteById(id);
		return "Student has been Deleted";
	}

	public List<Student> getStudentByName(String name) {
		return studentRepo.findByName(name);
	}

	public List<Student> getStudentsByNameAndEmail(String name,String email) {
		return studentRepo.findByNameAndEmail(name, email);
	}
	public Student getStudentByNameAndEmail(String name,String email) {
		return studentRepo.findByNameAndEmail(name, email).get(0);
	}
	public List<Student> getStudentsByNameOrEmail(String name,String email) {
		return studentRepo.findByNameOrEmail(name, email);
	}

	public List<Student> getStudentsByPagination(int pageNo,int pageSize) {
		Pageable pageable= PageRequest.of(pageNo-1, pageSize);
		return studentRepo.findAll(pageable).getContent();
	}
	public List<Student> getStudentsBysorting() {
		Sort sort=Sort.by(Sort.Direction.ASC,"name","mail");
		return studentRepo.findAll(sort);
	}

	public List<Student> getStudentsByDepartmentName(String name) {
		return studentRepo.findByDepartmentDepartmentName(name);
	}
	public List<Student> getStudentsBySubjectName(String name) {
		return studentRepo.findBySubjectsSubjectName(name);
	}

	public List<Student> getStudentslikeEmail(String email) {
		return studentRepo.findByEmailIsLike(email);
	}

	public List<Student> getStudentsNameStartsWith(String name) {
		return studentRepo.findByNameStartsWith(name);
	}
}

