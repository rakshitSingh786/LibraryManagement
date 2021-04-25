package com.capgemini.lms.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.capgemini.lms.exception.OrderNotFoundException;

import org.springframework.http.HttpStatus;



@ControllerAdvice
public class OrderNotFoundAdvice {
	@ExceptionHandler(OrderNotFoundException.class)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void exceptionHandlerMethod(OrderNotFoundException ex)
	{
		System.out.println(ex.getMessage());

}}
