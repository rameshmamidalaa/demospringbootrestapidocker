package com.springboot.rest.crud.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The following are the parameters accepted in the @SpringBootApplication annotation:
 * exclude: Exclude the list of classes from the auto configuration.
 * excludeNames: Exclude the list of fully qualified class names from the auto configuration. This parameter added since spring boot 1.3.0.
 * scanBasePackageClasses: Provide the list of classes that has to be applied for the @ComponentScan.
 * scanBasePackages Provide the list of packages that has to be applied for the @ComponentScan. This parameter added since spring boot 1.3.0
 * Remark: Instead of using @EnableAutoConfiguration, @ComponentScan & @Configuration on a class, you could just use only @SpringBootApplication which is equivalent to using @Configuration, @EnableAutoConfiguration and @ComponentScan with their default attributes.
 * 
 * @author rmamidala
 *
 */
@SpringBootApplication(scanBasePackages = "com.springboot.rest.crud.example")
public class DemoBasicSpringbootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBasicSpringbootRestApplication.class, args);
	}

}
