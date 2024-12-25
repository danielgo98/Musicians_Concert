package org.music.concerts.mapper;

import org.music.concerts.domain.Users;
import org.music.concerts.dto.UsersDTO;
import org.springframework.stereotype.Component;

@Component("userMapper")
public class UsersMapper {
	
	public static Users dtoToDomain(UsersDTO usersDTO) {
		
		Users users = Users.builder()
						   .idUser(usersDTO.getIdUser())
						   .username(usersDTO.getUsername())
						   .password(usersDTO.getPassword())
						   .build();
		
		return users;
		
	}
	
	public static UsersDTO domainToDTO(Users users) {
		
		UsersDTO usersDTO = UsersDTO.builder()
									.idUser(users.getIdUser())
									.username(users.getUsername())
									.password(users.getPassword())
									.build();
		
		return usersDTO;
		
	}

}
