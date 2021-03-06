package com.example.Taskin.Repository;

import com.example.Taskin.Model.Comment;
import com.example.Taskin.Model.Question;
import com.example.Taskin.Model.dto.QuestionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {


    /*
    @Query("select NEW com.example.Taskin.Model.dto.QuestionDTO(q.questionTitle,q.questionDescription,q.user,q.questionAskedDate) from Question q inner join q.questionTags qt where qt.questionTagName = ?1")
    List<QuestionDTO> findQuestionWithTags(String tag);
     */

    @Query("select q from Question q inner join q.questionTags qt where qt.questionTagName = ?1")
    List<Question> findQuestionWithTags(String tag);

    /*
    @Query("select NEW com.example.Taskin.Model.dto.QuestionDTO(q.questionTitle,q.questionDescription,q.user,q.questionAskedDate) from Question q inner join q.questionTags qt where qt.questionTagName IN :tags")
    List<QuestionDTO> getQuestionByQuestionTagsIn(@Param("tags") List<String> questionTags);
    */

    @Query("select q from Question q inner join q.questionTags qt where qt.questionTagName IN :tags")
    List<Question> getQuestionByQuestionTagsIn(@Param("tags") List<String> questionTags);

    @Query("select q.questionDescription from Question q where q.questionID = ?1")
    String getQuestionDescription(Integer id);

    @Query("select q from Question q where q.questionID = ?1")
    Question getQuestionInformation(Integer id);

    @Modifying
    @Query("update Question q set q.questionVoteCount = q.questionVoteCount + 1 where q.questionID = ?1")
    @Transactional
    void increaseVoteCountByQuestionID(Integer questionID);

    @Modifying
    @Query("update Question q set q.questionVoteCount = q.questionVoteCount - 1 where q.questionID = ?1")
    @Transactional
    void decreaseVoteCountByQuestionID(Integer questionID);

    @Query("select q.questionVoteCount from Question q where q.questionID = ?1")
    Integer getQuestionVoteCount(Integer questionID);

    @Query("select q.questionComments from Question q where q.questionID = ?1")
    List<Comment> getCommentsWithQuestionID(Integer questionID);


}
