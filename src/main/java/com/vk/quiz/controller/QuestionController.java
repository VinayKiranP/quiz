package com.vk.quiz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vk.quiz.common.dtos.ErrorDTO;
import com.vk.quiz.common.dtos.ResponseDto;
import com.vk.quiz.errors.BegDogException;
import com.vk.quiz.model.Question;
import com.vk.quiz.service.QuestionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<ResponseDto> getAllQuestions(){

        ResponseDto response = new ResponseDto();
        HttpStatus statusCode = HttpStatus.OK;

        try {
            response.setData(questionService.getAllQuestions());
            response.setSuccess(true);
        } catch (Exception e) {
            //statusCode = e.getHttpStatus();
            statusCode = HttpStatus.BAD_GATEWAY; 
            response.setError(ErrorDTO.getErrorFromException(e));
            response.setSuccess(false);
            log.error("error in Getting Questions error:{}, exception:{}", statusCode, ErrorDTO.getErrorFromException(e));
            // log.error("error in Getting Questions For Mandate mandate_id:{}, error:{}, exception:{}", mandateID, e.getHttpStatus(), ErrorDTO.getErrorFromRzpException(e));
        }
        return new ResponseEntity<>(response, statusCode);
    }

    @GetMapping("/{id}")
    public Optional<Question> getQuestionById(@PathVariable Integer id){
        return questionService.getQuestionsById(id);
    }

    @GetMapping("/category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable("category") String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public Question addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PutMapping("/update")
    public Question updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }

    @DeleteMapping("/delete")
    public Question deleteQuestion(@RequestBody Question question){
        return questionService.deleteQuestion(question);
    }
}
