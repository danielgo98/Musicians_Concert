package org.music.concerts.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UsersDTO implements Serializable {

	private static final long serialVersionUID = 7672487081217967677L;

	private long idUser;
	
	private String username;
	
	private String password;

}