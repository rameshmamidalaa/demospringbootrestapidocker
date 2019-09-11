/**
 * 
 */
package com.springboot.rest.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.rest.crud.example.entity.Student;

/**
 * @author rmamidala
 *
 */
@Repository
public interface StudentResourceRepository extends JpaRepository<Student, Long> {
	
	
}
