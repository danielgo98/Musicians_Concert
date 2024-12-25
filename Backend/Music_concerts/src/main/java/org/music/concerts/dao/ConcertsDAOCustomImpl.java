package org.music.concerts.dao;

import java.util.List;

import org.music.concerts.domain.Concerts;
import org.music.concerts.domain.ConcertsScore;
import org.music.concerts.dto.ConcertScoreDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

@Repository("concertsDAOCustom")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ConcertsDAOCustomImpl implements ConcertsDAOCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<ConcertScoreDTO> findAllConcertsWithFinalRatings() {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ConcertScoreDTO> query = criteriaBuilder.createQuery(ConcertScoreDTO.class);
		
		Root<ConcertsScore> scores = query.from(ConcertsScore.class);
		Join<ConcertsScore, Concerts> concerts = scores.join("concert", JoinType.LEFT);
		
		Expression<Long> addingRating = criteriaBuilder.coalesce(criteriaBuilder.sum(scores.get("score")), 0L);
		
		query.multiselect(concerts.get("idConcert"), concerts.get("name"), addingRating);
		query.groupBy(concerts.get("idConcert"), concerts.get("name"));
		
		List<ConcertScoreDTO> results = entityManager.createQuery(query).getResultList();
		
		return results;
	}

}
