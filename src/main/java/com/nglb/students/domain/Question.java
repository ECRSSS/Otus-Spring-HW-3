package com.nglb.students.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Question {
    private String text;
    private String rightAnswer;
    private List<String> wrongAnswers;

    public List<String> getAllAnswersInRandomOrder(){
        List<String> allAnswers = new ArrayList(wrongAnswers);
        allAnswers.add(rightAnswer);
        Collections.shuffle(allAnswers);
        return allAnswers;
    }

}
