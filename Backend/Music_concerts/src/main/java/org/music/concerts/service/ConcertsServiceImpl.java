package org.music.concerts.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.music.concerts.dao.ConcertsDAO;
import org.music.concerts.domain.Concerts;
import org.music.concerts.dto.ConcertScoreDTO;
import org.music.concerts.dto.ConcertsDTO;
import org.music.concerts.exceptions.ConcertNotFoundException;
import org.music.concerts.mapper.ConcertsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("concertsService")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = {
		RuntimeException.class, DataAccessException.class, ConcertNotFoundException.class
})
public class ConcertsServiceImpl implements ConcertsService {
	
	@Autowired
	private ConcertsDAO concertsDAO;
	
	@Override
	public List<ConcertsDTO> findAllDTO() {
		
		List<Concerts> concertsList = concertsDAO.findAll();
		
		return concertsList.stream()
				.map(concert -> ConcertsMapper.domainToDTO(concert))
				.collect(Collectors.toList());
	}

	@Override
	public ConcertsDTO findDTObyId(Long idConcert) {
		
		Optional<Concerts> concert = concertsDAO.findById(idConcert);
		ConcertsDTO concertDTO = null;
		
		
		if(concert.isPresent()) {
			concertDTO = ConcertsMapper.domainToDTO(concert.get());
		}
		
		return concertDTO;
	}

	@Override
	public ConcertsDTO save(ConcertsDTO concertsDTO) {
		
		Concerts concerts = ConcertsMapper.dtoToDomain(concertsDTO);
		
		Concerts concertSaved = concertsDAO.save(concerts);
		
		return ConcertsMapper.domainToDTO(concertSaved);
	}

	@Override
	public ConcertsDTO update(ConcertsDTO concertsDTO) throws ConcertNotFoundException {
		
		Optional<Concerts> concert = null;
		Concerts concertsUpdated = null;
		
		if(concertsDTO.getIdConcert() != null) {
			concert = concertsDAO.findById(concertsDTO.getIdConcert());
			
			if(concert.isPresent()) {
				concertsUpdated = concertsDAO.save(ConcertsMapper.dtoToDomain(concertsDTO));
			} else {
				throw new ConcertNotFoundException("El concierto que desea actualizar no se encuentra en nuestra base de datos");
			}
			
		}
		
		return ConcertsMapper.domainToDTO(concertsUpdated);
	}

	@Override
	public void delete(ConcertsDTO concertsDTO) throws ConcertNotFoundException {
		
		Optional<Concerts> concert = null;
		
		if(concertsDTO.getIdConcert() != null) {
			
			concert = concertsDAO.findById(concertsDTO.getIdConcert());
			
			if(concert.isPresent()) {
				concertsDAO.delete(concert.get());
			} else {
				throw new ConcertNotFoundException("El concierto que desea eliminar no se encuentra en nuestra base de datos");
			}
			
		}
		
	}

	@Override
	public List<ConcertScoreDTO> findAllConcertsRated() {
		return concertsDAO.findAllConcertsWithFinalRatings();
	}

	@Override
	public ConcertsDTO maxRatedConcert() {
		
		List<ConcertScoreDTO> concertsRatingList = findAllConcertsRated();
		
		ConcertsDTO concertDTO = null;
		
		ConcertScoreDTO maxConcertRate = concertsRatingList.stream()
				.max(Comparator.comparingLong(ConcertScoreDTO::getConcertRating))
				.orElse(null);
		
		if(maxConcertRate != null) {
			Optional<Concerts> concerts = concertsDAO.findById(maxConcertRate.getConcertId());
			
			if(concerts.isPresent()) {
				concertDTO = ConcertsMapper.domainToDTO(concerts.get());
			}
			
		}
		
		return concertDTO;
	}

}
