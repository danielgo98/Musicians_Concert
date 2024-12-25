package org.music.concerts.exceptions;

public class ConcertNotFoundException extends Exception {

	private static final long serialVersionUID = 1895711421709527022L;
	
	public ConcertNotFoundException(String message) {
		super(message);
	}

}
