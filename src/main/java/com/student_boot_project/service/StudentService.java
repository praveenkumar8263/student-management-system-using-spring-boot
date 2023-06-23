package com.student_boot_project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student_boot_project.config.ResponseStructure;
import com.student_boot_project.dao.StudentDao;
import com.student_boot_project.dto.Student;
import com.student_boot_project.exception.StudentNotFoundException;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	// ----------------------------

	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student) {
		// return studentDao.saveStudent(student); we are returning student response
		// entity
		student = studentDao.saveStudent(student);

		// Response Structure
		ResponseStructure<Student> responseStructure = new ResponseStructure<Student>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Student Added successfully!!");
		responseStructure.setData(student);

		// return new ResponseEntity<Student>(student,HttpStatus.CREATED); for only
		// response entity
		return new ResponseEntity<ResponseStructure<Student>>(responseStructure, HttpStatus.CREATED);
	}

	// ----------------------------

	// public Student findStudent(int studentId)
	public ResponseEntity<ResponseStructure<Student>> findStudent(int studentId) {
		Optional<Student> optional = studentDao.findStudentById(studentId);

		if (optional.isEmpty()) {
			throw new StudentNotFoundException("Fail to find the Student..!!!");
		} else {
			// return optional.get();
			Student student = optional.get();
			ResponseStructure<Student> responseStructure = new ResponseStructure<Student>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Student found");
			responseStructure.setData(student);
			return new ResponseEntity<ResponseStructure<Student>>(responseStructure, HttpStatus.FOUND);
		}
	}

	// -----------------------------

	// public Student updateStudentById(Student student,int studentId)
	public ResponseEntity<ResponseStructure<Student>> updateStudentById(Student student, int studentId) {
		Optional<Student> optional = studentDao.findStudentById(studentId);

		if (optional.isEmpty()) {
			throw new StudentNotFoundException("Fail to update the Student not exit..!!!");
		} else {
			student.setStudentId(studentId);
			// return studentDao.saveStudent(student);

			student = studentDao.saveStudent(student);

			ResponseStructure<Student> responseStructure = new ResponseStructure<Student>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Student updated successfully!!");
			responseStructure.setData(student);
			return new ResponseEntity<ResponseStructure<Student>>(responseStructure, HttpStatus.OK);

		}
	}

	// ------------------------------

	// public Student deleteStudent(int studentId)

	public ResponseEntity<ResponseStructure<Student>> deleteStudent(int studentId) {
		Optional<Student> optional = studentDao.findStudentById(studentId);

		if (optional.isEmpty()) {
			throw new StudentNotFoundException("Fail to find the Student data to delete..!!!");
		} else {
			Student student = optional.get();
			// return studentDao.deleteStudent(student);

			student = studentDao.deleteStudent(student);

			ResponseStructure<Student> responseStructure = new ResponseStructure<Student>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Student data deleted!!");
			responseStructure.setData(student);

			return new ResponseEntity<ResponseStructure<Student>>(responseStructure, HttpStatus.OK);

		}
	}

}
