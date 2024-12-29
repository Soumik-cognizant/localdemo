package com.cts.examportal.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.examportal.model.exam.Question;
import com.cts.examportal.model.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Set<Question> findByQuiz(Quiz quiz);
}
