/**
 * 
 */
package com.springboot.rest.crud.example.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest.crud.example.entity.Student;
import com.springboot.rest.crud.example.exception.StudentNotFoundException;
import com.springboot.rest.crud.example.model.StudentDto;
import com.springboot.rest.crud.example.repository.StudentResourceRepository;

/**
 * @author rmamidala
 *
 */
@Service
public class StudentResourceService {
	
	@Autowired
	private StudentResourceRepository repository;
	
	public List<StudentDto> getAllStudents() {
		return repository.findAll().stream().map(s -> {
			StudentDto studentDto = new StudentDto(s.getId(), s.getName(), s.getPassportNumber());
			return studentDto;
		}).collect(Collectors.toList());
	}
	
	public StudentDto getStudentDetailsById(Long id) throws StudentNotFoundException {
		return repository.findById(id).map(s -> {
			StudentDto studentDto = new StudentDto(s.getId(), s.getName(), s.getPassportNumber());
			return studentDto;
		}).orElseThrow(() -> new StudentNotFoundException("Student Not Found for this id::" +id));
	}
	public void saveStudentDetails(StudentDto studentDto) {
		Student student = new Student();
		student.setId(studentDto.getStudentId());
		student.setName(studentDto.getName());
		student.setPassportNumber(studentDto.getPassportNumber());
		student.setCreatedAt(new Date());
		repository.save(student);
	}
	public void updateStudentDetails(Long id, StudentDto studentDto) throws StudentNotFoundException {
		Student student = repository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student Not Found for this id::" +id));
		
		student.setId(studentDto.getStudentId());
		student.setName(studentDto.getName());
		student.setPassportNumber(studentDto.getPassportNumber());
		student.setUpdatedAt(new Date());
		repository.save(student);
	}
	public void deleteStudentDetails(Long id) throws StudentNotFoundException {
		Student student = repository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student Not Found for this id::" +id));
		repository.delete(student);
	}
}
