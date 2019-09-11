/**
 * 
 */
package com.springboot.rest.crud.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rmamidala
 *
 */
@Entity
@Table(name = "STUDENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STUDENT_ID", nullable = false)
	private Long id;
	@Column(name = "STUDENT_NAME")
	private String name;
	@Column(name = "STUDENT_PASSPORTNR")
	private String passportNumber;
	@CreationTimestamp
	@Column(name = "CREATED_AT")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "UPDATED_AT")
	private Date updatedAt;

}
