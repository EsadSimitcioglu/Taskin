package com.example.Taskin.Repository;

import com.example.Taskin.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {


    @Modifying
    @Query("delete from Comment c where c.commentID = ?1")
    @Transactional
    void deleteCommentWithID(Integer questionID);

//    @Modifying(clearAutomatically = true)
//    @Query("update Comment c set c = ?1 where c.commentID = ?2")
//    @Transactional
//    void updateComment(Comment comment, Integer answerID);

    @Modifying
    @Query("update Comment c set c.commentText = ?1 where c.commentID = ?2")
    @Transactional
    void updateComment(String commentText, Integer answerID);

    @Modifying
    @Query("update Comment c set c.commentVoteCount = c.commentVoteCount + 1 where c.commentID = ?1")
    @Transactional
    void increaseVoteCountByCommentID(Integer commentID);

    @Modifying
    @Query("update Comment c set c.commentVoteCount = c.commentVoteCount - 1 where c.commentID = ?1")
    @Transactional
    void decreaseVoteCountByCommentID(Integer commentID);


}
