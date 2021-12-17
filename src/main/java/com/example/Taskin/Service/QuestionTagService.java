package com.example.Taskin.Service;


import com.example.Taskin.Repository.QuestionTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionTagService {

    @Autowired
    QuestionTagRepository questionTagRepository;


}
