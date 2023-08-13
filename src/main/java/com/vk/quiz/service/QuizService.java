package com.vk.quiz.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.quiz.dao.QuestionDao;
import com.vk.quiz.dao.QuizDao;
import com.vk.quiz.model.Question;
import com.vk.quiz.model.QuestionWrapper;
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

    public List<QuestionWrapper> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDb = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUsers = new ArrayList<>();
        for(Question q : questionsFromDb){
            QuestionWrapper qw= new QuestionWrapper(
                q.getId(),
                q.getTitle(),
                q.getOption1(),
                q.getOption2(),
                q.getOption3(),
                q.getOption4());
            questionsForUsers.add(qw);
        }
        return questionsForUsers;
    }
}
