package org.music.concerts.service;

import java.util.List;

import org.music.concerts.dto.ConcertsScoreDTO;
import org.music.concerts.exceptions.ConcertNotFoundException;

public interface ConcertsScoreService {
	
	List<ConcertsScoreDTO> findAllDTO();
	
	ConcertsScoreDTO findDTObyId(Long id);
	
	List<ConcertsScoreDTO> findAllDTObyIdConcert(Long idConcert);
	
	ConcertsScoreDTO save(ConcertsScoreDTO concertsScoreDTO) throws ConcertNotFoundException;
	
	void delete(ConcertsScoreDTO concertsScoreDTO);
}
