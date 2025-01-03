package org.music.concerts.controller;

import java.util.List;

import org.music.concerts.dto.ConcertScoreDTO;
import org.music.concerts.dto.ConcertsDTO;
import org.music.concerts.exceptions.ConcertNotFoundException;
import org.music.concerts.service.ConcertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/concerts")
public class ConcertController {

	@Autowired
	private ConcertsService concertsService;
	
	
	@GetMapping()
	public ResponseEntity<?> getAll() {
		List<ConcertsDTO> concertsList = concertsService.findAllDTO();
		return ResponseEntity.status(HttpStatus.OK).body(concertsList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) throws ConcertNotFoundException {
		ConcertsDTO concertDTO = concertsService.findDTObyId(id);
		return ResponseEntity.status(HttpStatus.OK).body(concertDTO);
	}
	
	@GetMapping("/rated")
	public ResponseEntity<?> findAllConcertsWithRate() {
		List<ConcertScoreDTO> concertsScoresDTO = concertsService.findAllConcertsRated();
		return ResponseEntity.status(HttpStatus.OK).body(concertsScoresDTO);
	}
	
	@GetMapping("/rated/max")
	public ResponseEntity<?> getMaxRatedConcert() {
		ConcertsDTO concertScore = concertsService.maxRatedConcert();
		return ResponseEntity.status(HttpStatus.OK).body(concertScore);
	}
	
	@PostMapping()
	public ResponseEntity<?> save(@RequestBody ConcertsDTO concertsDTO) {
		ConcertsDTO concertSaved = concertsService.save(concertsDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(concertSaved);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id ,@RequestBody ConcertsDTO concertsDTO) throws ConcertNotFoundException {
		ConcertsDTO concertUpdated = concertsService.update(id, concertsDTO);
		return ResponseEntity.status(HttpStatus.OK).body(concertUpdated);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) throws ConcertNotFoundException {
		ConcertsDTO concertDeleted = concertsService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(concertDeleted);
	}
}
