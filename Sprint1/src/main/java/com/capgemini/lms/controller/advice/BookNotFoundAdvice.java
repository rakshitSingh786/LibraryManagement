package com.capgemini.lms.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.capgemini.lms.exception.BookNotFoundException;

@ControllerAdvice
public class BookNotFoundAdvice {
	@ExceptionHandler(BookNotFoundException.class)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void exceptionHandlerMethod(BookNotFoundException ex)
	{
		System.out.println(ex.getMessage());

}}
