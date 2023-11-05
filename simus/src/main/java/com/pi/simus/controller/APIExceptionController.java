package com.pi.simus.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pi.simus.model.Resposta;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.Endpoint;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class APIExceptionController {

  Resposta resposta;


  Logger logger = LogManager.getLogger(this.getClass());


  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<Resposta> handleSQLException(HttpServletRequest req,ConstraintViolationException e) {

    resposta = new Resposta();

    resposta.setErro(e.getSQLState());
    resposta.setMensagem(e.getLocalizedMessage());
    resposta.setStatus(HttpStatus.BAD_REQUEST);
    resposta.setCaminho(req.getRequestURL().toString());
    resposta.setMetodo(req.getMethod());

    return new ResponseEntity(resposta, resposta.getStatus());
  }
}
