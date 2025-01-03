package org.music.concerts.service;

import java.util.List;

import org.music.concerts.dto.ConcertScoreDTO;
import org.music.concerts.dto.ConcertsDTO;
import org.music.concerts.exceptions.ConcertNotFoundException;

public interface ConcertsService {
	
	List<ConcertsDTO> findAllDTO();
	
	ConcertsDTO findDTObyId(Long idConcert) throws ConcertNotFoundException;
	
	ConcertsDTO save(ConcertsDTO concertsDTO);
	
	ConcertsDTO update(Long idConcert, ConcertsDTO concertsDTO) throws ConcertNotFoundException;
	
	ConcertsDTO delete(Long idConcert) throws ConcertNotFoundException;
	
	List<ConcertScoreDTO> findAllConcertsRated();
	
	ConcertsDTO maxRatedConcert();

}
