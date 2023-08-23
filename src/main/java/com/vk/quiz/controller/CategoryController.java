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
import com.vk.quiz.model.Category;
import com.vk.quiz.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ResponseDto> getAllCategory(){

        ResponseDto response = new ResponseDto();
        HttpStatus statusCode = HttpStatus.OK;

        try {
            response.setData(categoryService.getAllCategory());
            response.setSuccess(true);
        } catch (Exception e) {
            //statusCode = e.getHttpStatus();
            statusCode = HttpStatus.BAD_GATEWAY; 
            response.setError(ErrorDTO.getErrorFromException(e));
            response.setSuccess(false);
            log.error("error in Getting Category error:{}, exception:{}", statusCode, ErrorDTO.getErrorFromException(e));
            // log.error("error in Getting Questions For Mandate mandate_id:{}, error:{}, exception:{}", mandateID, e.getHttpStatus(), ErrorDTO.getErrorFromRzpException(e));
        }
        return new ResponseEntity<>(response, statusCode);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getCategoryById(@PathVariable String id){
        ResponseDto response = new ResponseDto();
        HttpStatus statusCode = HttpStatus.OK;

        try {
            response.setData(categoryService.getCategoryById(id));
            response.setSuccess(true);
        } catch (Exception e) {
            statusCode = HttpStatus.BAD_GATEWAY; 
            response.setError(ErrorDTO.getErrorFromException(e));
            response.setSuccess(false);
            log.error("error in Getting Questions by Id error:{}, exception:{}", statusCode, ErrorDTO.getErrorFromException(e));
        }
        return new ResponseEntity<>(response, statusCode);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> addCategory(@RequestBody Category category){
        ResponseDto response = new ResponseDto();
        HttpStatus statusCode = HttpStatus.OK;

        try {
            response.setData(categoryService.addCategory(category));
            response.setSuccess(true);
        } catch (Exception e) {
            statusCode = HttpStatus.BAD_GATEWAY; 
            response.setError(ErrorDTO.getErrorFromException(e));
            response.setSuccess(false);
            log.error("error in Adding Category error:{}, exception:{}", statusCode, ErrorDTO.getErrorFromException(e));
        }
        return new ResponseEntity<>(response, statusCode);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateCategory(@RequestBody Category category){
        ResponseDto response = new ResponseDto();
        HttpStatus statusCode = HttpStatus.OK;

        try {
            response.setData(categoryService.updateCategory(category));
            response.setSuccess(true);
        } catch (Exception e) {
            statusCode = HttpStatus.BAD_GATEWAY; 
            response.setError(ErrorDTO.getErrorFromException(e));
            response.setSuccess(false);
            log.error("error in Updating Category error:{}, exception:{}", statusCode, ErrorDTO.getErrorFromException(e));
        }
        return new ResponseEntity<>(response, statusCode);
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> deleteCategory(@RequestBody Category category){
        ResponseDto response = new ResponseDto();
        HttpStatus statusCode = HttpStatus.OK;

        try {
            response.setData(categoryService.deleteCategory(category));
            response.setSuccess(true);
        } catch (Exception e) {
            statusCode = HttpStatus.BAD_GATEWAY; 
            response.setError(ErrorDTO.getErrorFromException(e));
            response.setSuccess(false);
            log.error("error in Deleting Category error:{}, exception:{}", statusCode, ErrorDTO.getErrorFromException(e));
        }
        return new ResponseEntity<>(response, statusCode);
    }
}
