package com.example.Taskin.Repository;

import com.example.Taskin.Model.Question;
import com.example.Taskin.Model.QuestionTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {

    @Query("select q from Question q inner join q.questionTags qt where qt.questionTagName = ?1")
    List<Question> findQuestionWithTags(String tag);

    List<Question> findQuestionsByQuestionTags(List<QuestionTag> tags);

    @Query("select q from Question q where q.questionID = ?1")
    String getQuestionInformation(Integer id);



}
