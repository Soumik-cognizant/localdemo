package com.cts.examportal.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.examportal.model.exam.Question;
import com.cts.examportal.model.exam.Quiz;
import com.cts.examportal.repository.QuestionRepository;
import com.cts.examportal.repository.QuizRepository;
import com.cts.examportal.service.QuestionService;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Question addQuestion(Question question,Long qid) {
//    	System.out.println("quiz id "+question.getQuiz().);
    	Quiz quiz = quizRepository.findById(qid).get();
    	question.setQuiz(quiz);
    	
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionRepository.findById(questionId).get();
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long quesId) {
       Question question = new Question();
       question.setQuesId(quesId);
     //Question question= this.questionRepository.findById(quesId).get();
       this.questionRepository.delete(question);
     // return question;
       
    }

    @Override
    public Question get(Long questionsId) {
       return this.questionRepository.getReferenceById(questionsId); 
       }
}
