package org.music.concerts.dao;

import org.music.concerts.domain.Concerts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertsDAO extends JpaRepository<Concerts, Long> {}
