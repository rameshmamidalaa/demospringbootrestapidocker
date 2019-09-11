/**
 * 
 */
package com.springboot.rest.crud.example.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author rmamidala
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "All Details about the Student")
public class StudentDto implements Serializable {
	
	private static final long serialVersionUID = 3357022128363058107L;

	@ApiModelProperty(value = "Student ID")
	@NotNull(message = "Student Id should not be NULL.")
	private Long studentId;
	@ApiModelProperty(value = "Name of the Student")
	private String name;
	@ApiModelProperty(value = "Passport Number of the Student")
	@NotNull(message = "Passport Number should not be NULL")
	private String passportNumber;
}
