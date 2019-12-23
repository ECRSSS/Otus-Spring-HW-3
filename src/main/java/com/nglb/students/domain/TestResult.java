package com.nglb.students.domain;

import lombok.Getter;

@Getter
public class TestResult {
    private int numOfRightAnswers;
    private int numOfIncorrectAnswers;

    public void incrementRights() {
        numOfIncorrectAnswers++;
    }

    public void incrementIncorrect() {
        numOfIncorrectAnswers++;
    }
}
