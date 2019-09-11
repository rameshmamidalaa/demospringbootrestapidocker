/**
 * 
 */
package com.springboot.rest.crud.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.springboot.rest.crud.example.model.StudentDto;
import com.springboot.rest.crud.example.service.StudentResourceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * @author rmamidala
 *
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j
@Api(tags = {"Operations pertaining to Student Details"})
public class StudentResourceController {
	
	@Autowired
	private StudentResourceService service;
	
	@ApiOperation(value = "Retrieve available Student Details")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 401, message = "The resource you were trying to reach is not found")
	})
	@GetMapping("/students")
	public ResponseEntity<List<StudentDto>> getAllStudents() {
		log.info("Fetching all the Student details");
		List<StudentDto> students = service.getAllStudents();
		if(students.isEmpty()) {
			log.error("No Student Data found::");
			return new ResponseEntity<List<StudentDto>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<StudentDto>>(students, HttpStatus.OK); 
	}
	
	@ApiOperation(value = "Retrieve the specific Student Details by passing the Student ID")
	@GetMapping("/students/{id}")
	public ResponseEntity<StudentDto> getStudentDetailsById(
			@ApiParam(value = "Student Id from which Student object will retrive", required = true) @PathVariable("id") Long id) {
		log.info("Fetching the requested Student with id {}", id);
		StudentDto student = service.getStudentDetailsById(id);
		return new ResponseEntity<StudentDto>(student, HttpStatus.OK) ;
	}
	
	@ApiOperation(value = "Add the new Student Details")
	@PostMapping("/students")
	public ResponseEntity<String> saveStudentDetails(@ApiParam(value = "Student object save in the database table", required = true) @Valid @RequestBody StudentDto studentDto, UriComponentsBuilder ucBuilder) {
		log.info("Creating a Student with id {}", studentDto.getStudentId());
		service.saveStudentDetails(studentDto);
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.setLocation(ucBuilder.path("/api/v1//students/{id}").buildAndExpand(studentDto.getStudentId()).toUri());
		return new ResponseEntity<String>("New Student Info created Successfully ::"+httpHeader, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Update the specific Student Details by passing the Student ID")
	@PutMapping("/students/{id}")
	public ResponseEntity<String> updateStudentDetails(
			@ApiParam(value = "Student Id to update the Student object", required = true) @PathVariable("id") Long id, 
			@ApiParam(value = "Update Student object", required = true) @Valid @RequestBody StudentDto studentDto) {
		log.info("Fetching & Updating Student with id {}", id);
		service.updateStudentDetails(id, studentDto);
		return new ResponseEntity<String>("Student Info Successfully updated for the requested id::"+id, HttpStatus.OK);
	}
	@ApiOperation(value = "Delete the Student Details by passing the Student ID")
	@DeleteMapping("/students/{id}")
	public ResponseEntity<String> deleteStudentDetailsById(
			@ApiParam(value = "Student Id from which Student object will delete from the database table", required = true) @PathVariable("id") Long id) {
		log.info("Fetching & Deleting Student with id {}", id);
		service.deleteStudentDetails(id);
		return new ResponseEntity<String>("Requested Student Info Successfully Deleted with id::"+id, HttpStatus.NO_CONTENT);
	}
}
