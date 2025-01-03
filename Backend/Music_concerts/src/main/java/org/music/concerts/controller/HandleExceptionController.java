package org.music.concerts.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.music.concerts.dto.ErrorDTO;
import org.music.concerts.exceptions.ConcertNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleExceptionController {

	@ExceptionHandler(ConcertNotFoundException.class)
	public ResponseEntity<?> concertNotFound(ConcertNotFoundException e) {
		
		ErrorDTO errorDTO = ErrorDTO.builder()
									.message(e.getMessage())
									.date(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
									.build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
	}
	
}
