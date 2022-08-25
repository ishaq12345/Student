package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.exception.ResourceNotFoundException;
import com.student.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public Integer saveStudent(Student student) {
		Student savedStudent=studentRepository.save(student);
		return savedStudent.getId();
	}
	
	@Override
	public List<Student> getStudents(){
		return studentRepository.findAll();
		
	}
	
	@Override
	public Optional<Student> getStudent(Integer id){
		return studentRepository.findById(id);
	}
	
	@Override
	public void deleteStudent(Integer id) {
		studentRepository.deleteById(id);
	}
	
	@Override
	public Student updateStudent(Student student, Integer id) {
		Student existingStudent=studentRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Student","id",id));
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setDateOfBirth(student.getDateOfBirth());
		
		studentRepository.save(existingStudent);
		return existingStudent;
		
	}
}
