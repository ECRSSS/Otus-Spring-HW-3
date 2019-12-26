package com.nglb.students.service;

import com.nglb.students.dao.QuestionsDao;
import com.nglb.students.domain.Question;
import com.nglb.students.domain.TestResult;
import com.nglb.students.domain.User;

import com.nglb.students.util.Utils;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class TestingRunnerImpl implements TestingRunner {

    @NonNull
    private final PoolService poolService;

    @NonNull
    private final QuestionsDao questionsDao;

    @NonNull
    private final LocaleService localizationService;

    @Override
    public void start() {
        try {
            User user = readUser();
            List<Question> questions = questionsDao.readQuestions(localizationService.getLocalizedFile("testItems"));
            TestResult result = poolService.startPool(user, questions);
            System.out.println(String.format(localizationService.getMessage("userResult"),user,result.getNumOfRightAnswers(),result.getNumOfRightAnswers() + result.getNumOfIncorrectAnswers()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private User readUser() {
        User user = new User();
        System.out.println(localizationService.getMessage("inputName"));
        user.setFirstName(Utils.scanner.nextLine());
        System.out.println(localizationService.getMessage("inputLastName"));
        user.setLastName(Utils.scanner.nextLine());
        return user;
    }
}
