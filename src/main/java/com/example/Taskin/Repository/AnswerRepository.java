package com.example.Taskin.Repository;

import com.example.Taskin.Model.Answer;
import com.example.Taskin.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer> {


    @Modifying
    @Query("update Answer a set a.answerVoteCount = a.answerVoteCount + 1 where a.answerID = ?1")
    @Transactional
    void increaseVoteCountByAnswerID(Integer answerID);

    @Modifying
    @Query("update Answer a set a.answerVoteCount = a.answerVoteCount - 1 where a.answerID = ?1")
    @Transactional
    void decreaseVoteCountByAnswerID(Integer answerID);

    @Modifying
    @Query("update Answer a set a = ?1 where a.answerID = ?2")
    @Transactional
    void updateAnswer(Answer answer,Integer answerID);

    @Query("select a.answerVoteCount from Answer a where a.answerID = ?1")
    Integer getAllAnswerVoteCount(Integer answerID);

    @Query("select a.answerComments from Answer a where a.answerID = ?1")
    List<Comment> getAnswerWithAnswerID(Integer answerID);

}
