package com.vk.quiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.quiz.dao.QuestionDao;
import com.vk.quiz.model.Question;

@Service
public class QuestionService {
    @Autowired
    private QuestionDao questionDao;

    public List<Question> getAllQuestions(){
        return questionDao.findAll();
    }

    public Optional<Question> getQuestionsById(Integer id) {
        return questionDao.findById(id);
    }
    
    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public Question addQuestion(Question question){
       return questionDao.save(question);
    }
}