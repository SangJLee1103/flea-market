package com.sangjun.flea.exception;

import com.sangjun.flea.dto.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@Slf4j
@RestControllerAdvice(annotations = RestController.class) //@RestController 적용
public class BadRequestException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseData methodValidException(MethodArgumentNotValidException e){
        return new ResponseData(HttpStatus.BAD_REQUEST.value(), e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseData dataViolationException(IllegalArgumentException e){
        return new ResponseData(HttpStatus.CONFLICT.value(), e.getMessage());
    }
}
