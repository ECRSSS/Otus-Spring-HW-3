package com.nglb.students;

import com.nglb.students.service.TestingRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StudentsApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(StudentsApplication.class,args);
        TestingRunner runner = context.getBean(TestingRunner.class);
        runner.start();
    }

}
