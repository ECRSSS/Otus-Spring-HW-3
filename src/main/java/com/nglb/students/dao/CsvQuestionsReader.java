package com.nglb.students.dao;

import com.nglb.students.domain.Question;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
public class CsvQuestionsReader implements QuestionsDao {

    @Override
    public List<Question> readQuestions(Resource source) throws IOException {
        List<Question> questions = new ArrayList<>();
        try (Scanner scanner = new Scanner(source.getFile())) {
            scanner.skip("question,answer\n");
            while (scanner.hasNextLine()) {
               questions.add(fromLineToQuestion(scanner.nextLine()));
            }
        }
        return questions;
    }

    private Question fromLineToQuestion(String line){
        String[] columns = line.split(",");
        String question = columns[0];
        List<String> answers = Arrays.asList(columns[1].split(";"));
        return new Question(question,answers.get(0),answers.subList(1,answers.size()));
    }
}
