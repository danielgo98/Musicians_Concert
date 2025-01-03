package org.music.concerts.mapper;

import org.music.concerts.domain.ConcertsScore;
import org.music.concerts.dto.ConcertsScoreDTO;

public class ConcertsScoreMapper {
	
	public static ConcertsScore dtoToDomain(ConcertsScoreDTO concertsScoreDTO) {

		ConcertsScore concertsScore = ConcertsScore.builder()
				.idConcertScore(concertsScoreDTO.getIdConcertScore())
				.concerts(ConcertsMapper.dtoToDomain(concertsScoreDTO.getConcertsDTO()))
				.score(concertsScoreDTO.getScore())
				.build();

		return concertsScore;
	}
	
	public static ConcertsScoreDTO domainToDTO(ConcertsScore concertsScore) {

		ConcertsScoreDTO concertsScoreDTO = ConcertsScoreDTO.builder()
				.idConcertScore(concertsScore.getIdConcertScore())
				.concertsDTO(ConcertsMapper.domainToDTO(concertsScore.getConcerts()))
				.score(concertsScore.getScore())
				.build();

		return concertsScoreDTO;
	}

}
