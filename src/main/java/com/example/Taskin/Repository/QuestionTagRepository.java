package com.example.Taskin.Repository;

import com.example.Taskin.Model.QuestionTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionTagRepository extends JpaRepository<QuestionTag,Integer> {

}
