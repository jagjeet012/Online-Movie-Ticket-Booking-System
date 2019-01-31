package org.jagjeet.omtbs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Theatre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String movieName;
	private String movieDate;

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}

	@Override
	public String toString() {
		return "Theatre [movieName=" + movieName + ", movieDate=" + movieDate + "]";
	}

}