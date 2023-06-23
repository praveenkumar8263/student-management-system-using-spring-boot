package com.student_boot_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student_boot_project.dto.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>
{
	
}
