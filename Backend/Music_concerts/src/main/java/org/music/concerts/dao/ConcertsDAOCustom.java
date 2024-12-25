package org.music.concerts.dao;

import java.util.List;

import org.music.concerts.dto.ConcertScoreDTO;

public interface ConcertsDAOCustom {

	List<ConcertScoreDTO> findAllConcertsWithFinalRatings();
	
}
