package org.music.concerts.dao;

import org.music.concerts.domain.ConcertsScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertsScoreDAO extends JpaRepository<ConcertsScore, Long> {}
