package com.nglb.students;

import com.nglb.students.service.TestingRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
@EnableAutoConfiguration(exclude = MessageSourceAutoConfiguration.class)
public class StudentsApplication {


	public StudentsApplication(ApplicationContext context){
		TestingRunner runner = context.getBean(TestingRunner.class);
		runner.start();
	}

	public static void main(String[] args) {

		SpringApplication.run(StudentsApplication.class, args);
	}

}
