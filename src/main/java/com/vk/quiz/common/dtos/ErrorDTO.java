package com.vk.quiz.common.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDTO {
    String message;
    String description;
    int code;
    String status;
    
    // public static ErrorDTO getErrorFromBegDogException(Exception e) {
    //     return ErrorDTO.builder()
    //             .message(e.getMessage())
    //             .status(e.getErrorCode().getPublicErrorCode().getValue())
    //             .code(e.getHttpStatus().value())
    //             .description(e.getErrorCode().getShortDescription())
    //             .build();
    // }

    public static ErrorDTO getErrorFromException(Exception e) {
        return ErrorDTO.builder()
                .message(e.getMessage())
                .status("500")
                .code(500)
                .description("")
                .build();
    }


}
