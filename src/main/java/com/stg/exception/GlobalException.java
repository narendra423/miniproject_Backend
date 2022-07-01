package com.stg.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.stg.entity.ExceptionResponce;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(value = { ExceptionClass.class })
	public ResponseEntity<ExceptionResponce> myFunction(ExceptionClass hospitalException,
			HttpServletRequest httpServletRequest) {
		ExceptionResponce responseError = new ExceptionResponce(hospitalException.getMessage(),
				httpServletRequest.getRequestURI());
		return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
	}
}
