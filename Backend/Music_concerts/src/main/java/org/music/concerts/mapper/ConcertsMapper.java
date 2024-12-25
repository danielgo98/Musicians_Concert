package org.music.concerts.mapper;

import org.music.concerts.domain.Concerts;
import org.music.concerts.dto.ConcertsDTO;
import org.springframework.stereotype.Component;

@Component("concertsMapper")
public class ConcertsMapper {

	public static Concerts dtoToDomain(ConcertsDTO concertsDTO) {

		Concerts concerts = Concerts.builder()
				.idConcert(concertsDTO.getIdConcert())
				.name(concertsDTO.getName())
				.location(concertsDTO.getLocation())
				.concertDate(concertsDTO.getConcertDate())
				.build();
		return concerts;
	}
	
	public static ConcertsDTO domainToDTO(Concerts concerts) {

		ConcertsDTO concertsDTO = ConcertsDTO.builder()
				.idConcert(concerts.getIdConcert())
				.name(concerts.getName())
				.location(concerts.getLocation())
				.concertDate(concerts.getConcertDate())
				.build();

		return concertsDTO;
	}
	
}
