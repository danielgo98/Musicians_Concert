package org.music.concerts.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ConcertsDTO implements Serializable {

	private static final long serialVersionUID = 4906490623450578964L;

	private Long idConcert;
	
	private String name;
	
	private LocalDate concertDate;
	
	private String location;
	
}
