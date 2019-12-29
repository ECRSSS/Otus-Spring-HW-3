package com.nglb.students.service;

import com.nglb.students.dao.QuestionsDao;
import com.nglb.students.domain.Question;
import com.nglb.students.domain.TestResult;
import com.nglb.students.domain.User;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
@AllArgsConstructor
public class TestingRunnerImpl implements TestingRunner {

    @NonNull
    private final PoolService poolService;

    @NonNull
    private final QuestionsDao questionsDao;

    @NonNull
    private final LocaleService localizationService;

    @NonNull
    private final IOService ioService;


    @Override
    @ShellMethod("Start student testing")
    public String start() {
        try {
            User user = readUser();
            List<Question> questions = questionsDao.readQuestions(localizationService.getLocalizedFile("testItems"));
            TestResult result = poolService.startPool(user, questions);
            return String.format(localizationService.getMessage("userResult"),user,result.getNumOfRightAnswers(),result.getNumOfRightAnswers() + result.getNumOfIncorrectAnswers());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private User readUser() {
        User user = new User();
        System.out.println(localizationService.getMessage("inputName"));
        user.setFirstName(ioService.readLine());
        System.out.println(localizationService.getMessage("inputLastName"));
        user.setLastName(ioService.readLine());
        return user;
    }
}
