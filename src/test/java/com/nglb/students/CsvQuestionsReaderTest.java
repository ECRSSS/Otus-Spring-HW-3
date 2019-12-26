package com.nglb.students;

import com.nglb.students.dao.CsvQuestionsReader;
import com.nglb.students.dao.QuestionsDao;
import com.nglb.students.domain.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CsvQuestionsReaderTest {

    @Autowired
    QuestionsDao dao;

    @Test
    void readTest() throws IOException {
        List<Question> expectedQuestions = Arrays.asList(
                new Question("Question 1","answer 1",Arrays.asList("answer 2","answer 3")),
                new Question("Question 2","answer 1",Arrays.asList("answer 2","answer 3"))
        );
        assertThat(dao.readQuestions(new ClassPathResource("testItems.csv")))
                .isEqualTo(expectedQuestions);
    }
}
