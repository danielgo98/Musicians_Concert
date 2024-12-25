package org.music.concerts.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ConcertsScoreDTO implements Serializable {

	private static final long serialVersionUID = -4219202502010293372L;

	private Long idConcertScore;

	private ConcertsDTO concertsDTO;
	
	private int score;
	
}
