package org.music.concerts.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.music.concerts.dao.ConcertsDAO;
import org.music.concerts.dao.ConcertsScoreDAO;
import org.music.concerts.domain.Concerts;
import org.music.concerts.domain.ConcertsScore;
import org.music.concerts.dto.ConcertsScoreDTO;
import org.music.concerts.exceptions.ConcertNotFoundException;
import org.music.concerts.mapper.ConcertsScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("concertsScoreService")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = {
		RuntimeException.class, DataAccessException.class, ConcertNotFoundException.class
})
public class ConcertsScoreServiceImpl implements ConcertsScoreService {
	
	@Autowired
	private ConcertsScoreDAO concertsScoreDAO;
	
	@Autowired
	private ConcertsDAO concertsDAO;

	@Override
	public List<ConcertsScoreDTO> findAllDTO() {
		
		List<ConcertsScore> concertsScoreList = concertsScoreDAO.findAllWithConcerts();
		
		return concertsScoreList.stream()
				.map(concert -> ConcertsScoreMapper.domainToDTO(concert))
				.collect(Collectors.toList());
	}

	@Override
	public ConcertsScoreDTO findDTObyId(Long id) {
		
		Optional<ConcertsScore> concertScore = concertsScoreDAO.findById(id);
		ConcertsScoreDTO concertScoreDTO = null;
		
		if(concertScore.isPresent()) {
			concertScoreDTO = ConcertsScoreMapper.domainToDTO(concertScore.get());
		}
		
		return concertScoreDTO;
	}

	@Override
	public List<ConcertsScoreDTO> findAllDTObyIdConcert(Long idConcert) {
		
		List<ConcertsScore> concertsScoreList = concertsScoreDAO.findAllScoresByConcertsId(idConcert);
		
		return concertsScoreList.stream()
				.map(concert -> ConcertsScoreMapper.domainToDTO(concert))
				.collect(Collectors.toList());
	}

	@Override
	public ConcertsScoreDTO save(ConcertsScoreDTO concertsScoreDTO) throws ConcertNotFoundException {
		
		Optional<Concerts> concertFound = concertsDAO.findById(concertsScoreDTO.getConcertsDTO().getIdConcert());
		
		if(!concertFound.isPresent()) {
			throw new ConcertNotFoundException("El concierto indicado no existe en nuestra base de datos");
		}
		
		ConcertsScore concertsScoreSaved = concertsScoreDAO.save(ConcertsScoreMapper.dtoToDomain(concertsScoreDTO));
		
		return ConcertsScoreMapper.domainToDTO(concertsScoreSaved);
	}

	@Override
	public void delete(ConcertsScoreDTO concertsScoreDTO) {
		
		Optional<ConcertsScore> concertScore = null;
		
		if(concertsScoreDTO.getIdConcertScore() != null) {
			concertScore = concertsScoreDAO.findById(concertsScoreDTO.getIdConcertScore());
			
			if(concertScore.isPresent()) {
				concertsScoreDAO.delete(concertScore.get());
			}
		}
	}

}
