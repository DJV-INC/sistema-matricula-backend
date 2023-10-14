package com.pi.simus.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;


@ControllerAdvice
public class APIExceptionController {
  @ResponseStatus(
        value = HttpStatus.BAD_REQUEST,
        reason = "Dados já cadastrados, verificar dados")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void handleSQLException(DataIntegrityViolationException e) {
    }
}
