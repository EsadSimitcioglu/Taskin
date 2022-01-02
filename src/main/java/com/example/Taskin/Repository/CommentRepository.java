package com.example.Taskin.Repository;

import com.example.Taskin.Model.Answer;
import com.example.Taskin.Model.Comment;
import com.example.Taskin.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {




    @Modifying
    @Query("delete from Comment c where c.answer.answerID = ?1")
    @Transactional
    void deleteCommentWithAnswerID(Integer answerID);

    @Modifying
    @Query("delete from Comment c where c.question.questionID = ?1")
    @Transactional
    void deleteCommentWithQuestionID(Integer questionID);

    @Modifying
    @Query("update Comment c set c.commentText = ?1 where c.commentID = ?2")
    @Transactional
    void updateComment(String commentText, Integer answerID);

    @Modifying
    @Query("update Comment c set c.commentVoteCount = c.commentVoteCount + 1 where c.commentID = ?1")
    @Transactional
    void updateVoteCountByCommentID(Integer commentID);


}
