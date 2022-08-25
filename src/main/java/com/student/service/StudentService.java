package com.student.service;

import java.util.List;
import java.util.Optional;

import com.student.model.Student;

public interface StudentService {
	
	Integer saveStudent(Student student);
	
	List<Student> getStudents();
	
	Optional<Student> getStudent(Integer id);
	
	public void deleteStudent(Integer id);
	
	Student updateStudent(Student student, Integer id);
	
}
