package com.student_boot_project.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student_boot_project.dto.Student;
import com.student_boot_project.repo.StudentRepo;

@Repository
public class StudentDao {
	
	@Autowired
	private StudentRepo studentRepo;
	
	//-------------------------------
	
	public Student saveStudent(Student student)
	{
		return studentRepo.save(student);
	}
	
	//--------------------------------
	
	public Optional<Student> findStudentById(int studentId) //to not throw null pointer exception
	{
		 return studentRepo.findById(studentId);
	}
	
	//---------------------------------
	
	public Student deleteStudent(Student student)
	{
		studentRepo.delete(student);
		return student;
	}
	
	//---------------------------------
	

}
