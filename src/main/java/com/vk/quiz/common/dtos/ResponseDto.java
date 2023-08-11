package com.vk.quiz.common.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
public class ResponseDto {
    private Object data;
    private boolean success;
    private ArrayList<String> errors;

    public void setError(String errorMessage) {
        ErrorDTO.builder().message(errorMessage).build();
        if (errors == null) {
            errors = new ArrayList<>();
        }
        errors.add(errorMessage);
    }

    public void setError(ErrorDTO errorDTO) {
        if (errors == null) {
            errors = new ArrayList<>();
        }
        errors.add(errorDTO.getMessage());
    }
}


