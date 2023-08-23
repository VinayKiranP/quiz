package com.vk.quiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.quiz.dao.CommentatorDao;
import com.vk.quiz.model.Commentator;

@Service
public class CommentatorService {
    @Autowired
    private CommentatorDao commentatorDao;

    public Commentator addCommentator(Commentator commentator){
       return commentatorDao.save(commentator);
    }
}
