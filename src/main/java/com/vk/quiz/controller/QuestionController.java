package com.vk.quiz.controller;

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
    public ResponseEntity<ResponseDto> getQuestionById(@PathVariable Integer id){
        ResponseDto response = new ResponseDto();
        HttpStatus statusCode = HttpStatus.OK;

        try {
            response.setData(questionService.getQuestionsById(id));
            response.setSuccess(true);
        } catch (Exception e) {
            statusCode = HttpStatus.BAD_GATEWAY; 
            response.setError(ErrorDTO.getErrorFromException(e));
            response.setSuccess(false);
            log.error("error in Getting Questions by Id error:{}, exception:{}", statusCode, ErrorDTO.getErrorFromException(e));
        }
        return new ResponseEntity<>(response, statusCode);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<ResponseDto> getQuestionByCategory(@PathVariable("category") String category){
        ResponseDto response = new ResponseDto();
        HttpStatus statusCode = HttpStatus.OK;

        try {
            response.setData(questionService.getQuestionsByCategory(category));
            response.setSuccess(true);
        } catch (Exception e) {
            statusCode = HttpStatus.BAD_GATEWAY; 
            response.setError(ErrorDTO.getErrorFromException(e));
            response.setSuccess(false);
            log.error("error in Getting Questions by Category error:{}, exception:{}", statusCode, ErrorDTO.getErrorFromException(e));
        }
        return new ResponseEntity<>(response, statusCode);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addQuestion(@RequestBody Question question){
        ResponseDto response = new ResponseDto();
        HttpStatus statusCode = HttpStatus.OK;

        try {
            response.setData(questionService.addQuestion(question));
            response.setSuccess(true);
        } catch (Exception e) {
            statusCode = HttpStatus.BAD_GATEWAY; 
            response.setError(ErrorDTO.getErrorFromException(e));
            response.setSuccess(false);
            log.error("error in Adding Questions error:{}, exception:{}", statusCode, ErrorDTO.getErrorFromException(e));
        }
        return new ResponseEntity<>(response, statusCode);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateQuestion(@RequestBody Question question){
        ResponseDto response = new ResponseDto();
        HttpStatus statusCode = HttpStatus.OK;

        try {
            response.setData(questionService.updateQuestion(question));
            response.setSuccess(true);
        } catch (Exception e) {
            statusCode = HttpStatus.BAD_GATEWAY; 
            response.setError(ErrorDTO.getErrorFromException(e));
            response.setSuccess(false);
            log.error("error in Updating Questions error:{}, exception:{}", statusCode, ErrorDTO.getErrorFromException(e));
        }
        return new ResponseEntity<>(response, statusCode);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteQuestion(@RequestBody Question question){
        ResponseDto response = new ResponseDto();
        HttpStatus statusCode = HttpStatus.OK;

        try {
            response.setData(questionService.deleteQuestion(question));
            response.setSuccess(true);
        } catch (Exception e) {
            statusCode = HttpStatus.BAD_GATEWAY; 
            response.setError(ErrorDTO.getErrorFromException(e));
            response.setSuccess(false);
            log.error("error in Deleting Questions error:{}, exception:{}", statusCode, ErrorDTO.getErrorFromException(e));
        }
        return new ResponseEntity<>(response, statusCode);
    }
}
