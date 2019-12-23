package com.nglb.students.service;

import com.nglb.students.dao.QuestionsDao;
import com.nglb.students.domain.Question;
import com.nglb.students.domain.TestResult;
import com.nglb.students.domain.User;

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
            System.out.println("Пользователь " + user + " правильно ответил на "
                    + result.getNumOfRightAnswers() + "из "
                    + (result.getNumOfRightAnswers() + result.getNumOfIncorrectAnswers())
                    + "вопросов");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private User readUser() {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        user.setFirstName(scanner.nextLine());
        System.out.println("Введите фамилию: ");
        user.setLastName(scanner.nextLine());
        return user;
    }
}
