package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@GetMapping("/getById/{id}")
	public Student getStudentById(@PathVariable String id) {
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/all")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	@PostMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id) {
		return studentService.deleteStudent(id);
	}

	@GetMapping("/{name}")
	public List<Student> getStudentByName(@PathVariable String name) {
		return studentService.getStudentByName(name);
	}
	@GetMapping("/studentsByNameAndEmail")
	public List<Student> studentsByNameAndEmail(@RequestParam String name,@RequestParam String email) {
		return studentService.getStudentsByNameAndEmail(name, email);
	}

	@GetMapping("/studentByNameAndEmail")
	public Student studentByNameAndEmail(@RequestParam String name,@RequestParam String email) {
		return studentService.getStudentByNameAndEmail(name, email);
	}

	@GetMapping("/studentsByNameOrEmail")
	public List<Student> studentsByNameOrEmail(@RequestParam String name,@RequestParam String email) {
		return studentService.getStudentsByNameOrEmail(name, email);
	}

	@GetMapping("/all/pagination")
	public List<Student> getStudentsByPagination(@RequestParam int pageNo,@RequestParam int pageSize) {
		return studentService.getStudentsByPagination(pageNo, pageSize);
	}

	@GetMapping("/all/sorting")
	public List<Student> getStudentsBysorting() {
		return studentService.getStudentsBysorting();
	}

	@GetMapping("/departmentName/{name}")
	public List<Student> getStudentByDepartmentName(@PathVariable String name) {
		return studentService.getStudentsByDepartmentName(name);
	}

	@GetMapping("/subjectName/{name}")
	public List<Student> getStudentBySubjectName(@PathVariable String name) {
		return studentService.getStudentsBySubjectName(name);
	}

	@GetMapping("/emaillike/{email}")
	public List<Student> getStudentsLikeEmail(@PathVariable String email) {
		return studentService.getStudentslikeEmail(email);
	}

	@GetMapping("/startswith/{name}")
	public List<Student> getStudentsNameStartsWith(@PathVariable String name) {
		return studentService.getStudentsNameStartsWith(name);
	}

}
