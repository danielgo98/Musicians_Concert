package org.music.concerts.domain;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CONCERTS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Concerts implements Serializable {

	private static final long serialVersionUID = -5252810108629360776L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONCERT")
	private long idConcert;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "CONCERT_DATE")
	private LocalDate concertDate;
	
	@Column(name = "LOCATION")
	private String location;

}
