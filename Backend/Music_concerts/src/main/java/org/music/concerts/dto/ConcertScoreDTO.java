package org.music.concerts.dto;

import java.io.Serializable;

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
public class ConcertScoreDTO implements Serializable {

	private static final long serialVersionUID = -6785346580459766492L;
	
	private Long concertId;
	
	private String concertName;
	
	private Long concertRating;

}
