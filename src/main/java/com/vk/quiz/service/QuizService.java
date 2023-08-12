package com.vk.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.quiz.dao.QuestionDao;
import com.vk.quiz.dao.QuizDao;
import com.vk.quiz.model.Question;
import com.vk.quiz.model.Quiz;

@Service
public class QuizService {
    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuestionDao questionDao;

    public Quiz addQuiz(String category, Integer numQ, String title){
        Quiz quiz = new Quiz();
        List<Question> questions = questionDao.getRandomQuestionsByCategory(category, numQ);
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        return quizDao.save(quiz);
    }
}
