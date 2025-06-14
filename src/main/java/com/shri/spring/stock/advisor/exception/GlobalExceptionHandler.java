package com.shri.spring.stock.advisor.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception ex) {
        log.error("Exception occurred", ex);
        return ResponseEntity
                .internalServerError()
                .body(new ErrorMessage(500, "Internal server error, please try again later or contact support"));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ErrorMessage> handleNoDataFoundException(NoDataFoundException ex) {
        log.error("No data found, pls check input", ex);
        return ResponseEntity
                .badRequest()
                .body(new ErrorMessage(404, "No data found"));
    }

}
