package org.music.concerts.service;

import org.music.concerts.dto.UsersDTO;

public interface UsersService {
	
	UsersDTO findDTObyId(Long userId);
	
}
