package org.music.concerts.dao;

import org.music.concerts.domain.ConcertsScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertsScoreDAO extends JpaRepository<ConcertsScore, Long> {
	
//	@Query(value = "SELECT cs FROM ConcertsScore LEFT JOIN FETCH cs.concerts WHERE cs.concerts IS NOT NULL")
//	List<ConcertsScore> findAllWithConcerts() throws DataAccessException;
//	
//	@Query(value = "SELECT cs FROM ConcertsScore LEFT JOIN FETCH cs.concerts WHERE cs.concerts IS NOT NULL AND cs.concerts.idConcert = :concertId")
//	List<ConcertsScore> findAllScoresByConcertsId(@Param("concertId")Long concertId) throws DataAccessException;
	
}
