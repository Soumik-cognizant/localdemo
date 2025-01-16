package com.cts.examportal.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.examportal.model.exam.Question;
import com.cts.examportal.model.exam.Quiz;
import java.util.List;
import java.util.Optional;


public interface QuestionRepository extends JpaRepository<Question, Long> {
    Set<Question> findByQuiz(Quiz quiz);
    Optional<Question> findByQuesId(Long quesId);
    
    @Modifying
    @Query("DELETE FROM Question e WHERE e.quesId = :id")
    void deleteByqId(@Param("id") Long id);
}
