package org.music.concerts.dao;

import org.music.concerts.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDAO extends JpaRepository<Users, Long> {}
