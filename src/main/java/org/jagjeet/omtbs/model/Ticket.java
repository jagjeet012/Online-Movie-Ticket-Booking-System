package org.jagjeet.omtbs.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String movieName;
	private Date movieDate;
	private String movieTime;
	private int noOfSeats;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Date getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(Date movieDate) {
		this.movieDate = movieDate;
	}

	public String getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	@Override
	public String toString() {
		return "Ticket [userId=" + userId + ", movieName=" + movieName + ", movieDate=" + movieDate + ", movieTime="
				+ movieTime + ", noOfSeats=" + noOfSeats + "]";
	}

}