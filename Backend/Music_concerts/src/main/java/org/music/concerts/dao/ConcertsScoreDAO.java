package org.music.concerts.dao;

import java.util.List;

import org.music.concerts.domain.ConcertsScore;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConcertsScoreDAO extends JpaRepository<ConcertsScore, Long> {
	
	
	@Query(value = "SELECT cs FROM ConcertsScore LEFT JOIN fetc cs.concert")
	List<ConcertsScore> findAllWithConcerts() throws DataAccessException;
	
	@Query(value = "SELECT cs FROM ConcertsScore LEFT JOIN fetch cs.concert WHERE cs.concert.idConcert = :concertId")
	List<ConcertsScore> findAllScoresByConcertsId(@Param("concertId")Long concertId) throws DataAccessException;
	
}
