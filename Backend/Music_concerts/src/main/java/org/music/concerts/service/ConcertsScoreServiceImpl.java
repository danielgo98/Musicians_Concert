package org.music.concerts.service;

import org.music.concerts.dao.ConcertsScoreDAO;
import org.music.concerts.exceptions.ConcertNotFoundException;
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


}
