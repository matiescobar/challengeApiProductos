package com.example.demo.exception;

import com.example.demo.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDTO> handlerBadRequestException(){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("Article not found");
        errorDTO.setDescription("Bad Request");
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
