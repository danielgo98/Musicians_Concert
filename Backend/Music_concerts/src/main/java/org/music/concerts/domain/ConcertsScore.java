package org.music.concerts.domain;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CONCERTS_SCORE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ConcertsScore implements Serializable {

	private static final long serialVersionUID = -4446793271008970121L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONCERT_SCORE")
	private long idConcertScore;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_CONCERT")
	private Concerts concert;
	
	@Column(name = "SCORE", nullable = false)
	private int score;
	
}
