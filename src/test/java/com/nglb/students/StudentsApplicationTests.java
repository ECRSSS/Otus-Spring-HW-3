package com.nglb.students;

import com.nglb.students.dao.CsvQuestionsReader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

@SpringBootTest
class StudentsApplicationTests {

	@Test
	void contextLoads() throws IOException {
		CsvQuestionsReader reader = new CsvQuestionsReader();
		reader.readQuestions(
				new FileSystemResource("/home/nik/Документы/GitHub/stud" +
						"ents/src/main/resources/localizedFiles/testItems_en.csv"));
	}


}
