package com.cts.examportal.service;




import java.util.Set;

import com.cts.examportal.model.exam.Question;
import com.cts.examportal.model.exam.Quiz;

public interface QuestionService {

    public Question addQuestion(Question question,Long qid);

    public Question updateQuestion(Question question);

    public Set<Question> getQuestions();

    public Question getQuestion(Long questionId);

    public Set<Question> getQuestionsOfQuiz(Quiz quiz);

    public void deleteQuestion(Long quesId);

    public Question get(Long questionsId);

}
