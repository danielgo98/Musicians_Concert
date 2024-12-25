package org.music.concerts.service;

import java.util.List;

import org.music.concerts.dto.ConcertsDTO;
import org.music.concerts.exceptions.ConcertNotFoundException;

public interface ConcertsScoreService {

	List<ConcertsDTO> findAllDTO();
	
	ConcertsDTO findDTObyId(Long idConcert);
	
	ConcertsDTO save(ConcertsDTO concertsDTO);
	
	ConcertsDTO update(ConcertsDTO concertsDTO) throws ConcertNotFoundException;
	
	void delete(ConcertsDTO concertsDTO) throws ConcertNotFoundException;
	
}
