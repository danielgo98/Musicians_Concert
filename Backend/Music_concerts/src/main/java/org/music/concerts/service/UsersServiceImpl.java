package org.music.concerts.service;

import java.util.Optional;

import org.music.concerts.dao.UsersDAO;
import org.music.concerts.domain.Users;
import org.music.concerts.dto.UsersDTO;
import org.music.concerts.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("usersService")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = {
		RuntimeException.class, DataAccessException.class
})
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDAO usersDAO;
	
	@Override
	public UsersDTO findDTObyId(Long userId) {
		
		Optional<Users> user = usersDAO.findById(userId);
		UsersDTO userDTO = null;
		
		if(user.isPresent()) {
			userDTO = UsersMapper.domainToDTO(user.get());
		}
		
		return userDTO;
	}

}
