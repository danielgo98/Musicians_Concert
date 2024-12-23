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
public class ConcertsScoreDTO implements Serializable {

	private static final long serialVersionUID = -4219202502010293372L;

	private long idConcertScore;

	private ConcertsDTO concertsDTO;
	
	private int score;
	
}
