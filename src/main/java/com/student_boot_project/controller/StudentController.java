package com.student_boot_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student_boot_project.config.ResponseStructure;
import com.student_boot_project.dto.Student;
import com.student_boot_project.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//----------------------------------
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student)
	{
		return studentService.saveStudent(student);
	}
	
	//-----------------------------------
	
	@GetMapping
	//public Student findStudent(@RequestParam int studentId)
	public ResponseEntity<ResponseStructure<Student>> findStudent(@RequestParam int studentId)
	{
		return studentService.findStudent(studentId);
	}
	
	//------------------------------------
	
	@PutMapping
	//public Student updateStudent(@RequestBody Student student,int studentId)
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student,int studentId)
	{
		return studentService.updateStudentById(student, studentId);
	}
	
	//-------------------------------------
	
	@DeleteMapping
	//public Student deleteStudent(@RequestParam int studentId)
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@RequestParam int studentId)
	{
		return studentService.deleteStudent(studentId);
	}

}
