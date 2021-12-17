package com.example.Taskin.Service;

import com.example.Taskin.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

}
