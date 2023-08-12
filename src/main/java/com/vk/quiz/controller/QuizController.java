package com.vk.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vk.quiz.common.dtos.ErrorDTO;
import com.vk.quiz.common.dtos.ResponseDto;
import com.vk.quiz.service.QuizService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createQuiz(@RequestParam String category, @RequestParam Integer numQ, @RequestParam String title){
        ResponseDto response = new ResponseDto();
        HttpStatus statusCode = HttpStatus.OK;

        try {
            response.setData(quizService.addQuiz(category, numQ, title));
            response.setSuccess(true);
        } catch (Exception e) {
            statusCode = HttpStatus.BAD_GATEWAY; 
            response.setError(ErrorDTO.getErrorFromException(e));
            response.setSuccess(false);
            log.error("error in Adding Quiz error:{}, exception:{}", statusCode, ErrorDTO.getErrorFromException(e));
        }
        return new ResponseEntity<>(response, statusCode);
    }
    
}
