package com.nglb.students.service;

import com.nglb.students.domain.Question;
import com.nglb.students.domain.TestResult;
import com.nglb.students.domain.User;

import java.util.List;

public interface PoolService {

    TestResult startPool(User user, List<Question> questions);
}
