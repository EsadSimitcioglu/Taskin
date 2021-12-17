package com.example.Taskin.Repository;

import com.example.Taskin.Model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {


    @Modifying
    @Query("update Answer a set a.answerVoteCount = a.answerVoteCount + 1 where a.answerID = ?1")
    @Transactional
    Answer updateVoteCountByAnswerID(Integer answerID);

}
