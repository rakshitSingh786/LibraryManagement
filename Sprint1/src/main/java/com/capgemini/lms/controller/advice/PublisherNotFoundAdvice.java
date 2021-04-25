package com.capgemini.lms.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


import com.capgemini.lms.exception.PublisherNotFoundException;

import org.springframework.http.HttpStatus;



@ControllerAdvice
public class PublisherNotFoundAdvice {
	@ExceptionHandler(PublisherNotFoundException.class)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void exceptionHandlerMethod(PublisherNotFoundException ex)
	{
		System.out.println(ex.getMessage());

}}
