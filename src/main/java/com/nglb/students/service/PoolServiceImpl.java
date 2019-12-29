package com.nglb.students.service;

import com.nglb.students.domain.Question;
import com.nglb.students.domain.TestResult;
import com.nglb.students.domain.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PoolServiceImpl implements PoolService {


    @NonNull
    private final LocaleService localizationService;

    @NonNull
    private final IOService ioService;


    @Override
    public TestResult startPool(User user, List<Question> questions) {
        TestResult result = new TestResult();
        questions.forEach(question -> {
            if (ask(question)) {
                result.incrementRights();
            } else {
                result.incrementIncorrect();
            }
        });
        return result;
    }

    private boolean ask(Question question) {
        System.out.println(localizationService.getMessage("question") + question.getText());
        List<String> answers = question.getAllAnswersInRandomOrder();
        System.out.println(localizationService.getMessage("answers"));
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(i + 1 + ". " + answers.get(i));
        }
        int answerNum = getAnswer();
        while (answerNum > answers.size() || answerNum < 1) {
            answerNum = getAnswer();
        }
        return answers.get(answerNum - 1).equals(question.getRightAnswer());
    }

    private int getAnswer() {
        System.out.println(localizationService.getMessage("inputRightAnswer"));
        return Integer.parseInt(ioService.readLine());
    }
}
