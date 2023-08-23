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
import com.vk.quiz.model.Story;
import com.vk.quiz.service.StoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("story")
public class StoryController {
    @Autowired
    StoryService storyService;

    @GetMapping
    public ResponseEntity<ResponseDto> getAllStory(){

        ResponseDto response = new ResponseDto();
        HttpStatus statusCode = HttpStatus.OK;

        try {
            response.setData(storyService.getAllStory());
            response.setSuccess(true);
        } catch (Exception e) {
            //statusCode = e.getHttpStatus();
            statusCode = HttpStatus.BAD_GATEWAY; 
            response.setError(ErrorDTO.getErrorFromException(e));
            response.setSuccess(false);
            log.error("error in Getting Story error:{}, exception:{}", statusCode, ErrorDTO.getErrorFromException(e));
            // log.error("error in Getting Questions For Mandate mandate_id:{}, error:{}, exception:{}", mandateID, e.getHttpStatus(), ErrorDTO.getErrorFromRzpException(e));
        }
        return new ResponseEntity<>(response, statusCode);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getStoryById(@PathVariable String id){
        ResponseDto response = new ResponseDto();
        HttpStatus statusCode = HttpStatus.OK;

        try {
            response.setData(storyService.getStoryById(id));
            response.setSuccess(true);
        } catch (Exception e) {
            statusCode = HttpStatus.BAD_GATEWAY; 
            response.setError(ErrorDTO.getErrorFromException(e));
            response.setSuccess(false);
            log.error("error in Getting Story by Id error:{}, exception:{}", statusCode, ErrorDTO.getErrorFromException(e));
        }
        return new ResponseEntity<>(response, statusCode);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> addStory(@RequestBody Story story){
        ResponseDto response = new ResponseDto();
        HttpStatus statusCode = HttpStatus.OK;

        try {
            response.setData(storyService.addStory(story));
            response.setSuccess(true);
        } catch (Exception e) {
            statusCode = HttpStatus.BAD_GATEWAY; 
            response.setError(ErrorDTO.getErrorFromException(e));
            response.setSuccess(false);
            log.error("error in Adding Story error:{}, exception:{}", statusCode, ErrorDTO.getErrorFromException(e));
        }
        return new ResponseEntity<>(response, statusCode);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateStory(@RequestBody Story story){
        ResponseDto response = new ResponseDto();
        HttpStatus statusCode = HttpStatus.OK;

        try {
            response.setData(storyService.updateStory(story));
            response.setSuccess(true);
        } catch (Exception e) {
            statusCode = HttpStatus.BAD_GATEWAY; 
            response.setError(ErrorDTO.getErrorFromException(e));
            response.setSuccess(false);
            log.error("error in Updating Story error:{}, exception:{}", statusCode, ErrorDTO.getErrorFromException(e));
        }
        return new ResponseEntity<>(response, statusCode);
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> deleteStory(@RequestBody Story story){
        ResponseDto response = new ResponseDto();
        HttpStatus statusCode = HttpStatus.OK;

        try {
            response.setData(storyService.deleteStory(story));
            response.setSuccess(true);
        } catch (Exception e) {
            statusCode = HttpStatus.BAD_GATEWAY; 
            response.setError(ErrorDTO.getErrorFromException(e));
            response.setSuccess(false);
            log.error("error in Deleting Story error:{}, exception:{}", statusCode, ErrorDTO.getErrorFromException(e));
        }
        return new ResponseEntity<>(response, statusCode);
    }
}
