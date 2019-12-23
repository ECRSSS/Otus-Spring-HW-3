package com.nglb.students.dao;

import com.nglb.students.domain.Question;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

public interface QuestionsDao {

    List<Question> readQuestions(Resource source) throws IOException;
}
