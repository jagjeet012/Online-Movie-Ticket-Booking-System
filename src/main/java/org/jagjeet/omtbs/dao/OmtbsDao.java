package org.jagjeet.omtbs.dao;

import java.util.List;

import org.jagjeet.omtbs.model.Theatre;
import org.jagjeet.omtbs.model.Ticket;
import org.jagjeet.omtbs.model.User;

public interface OmtbsDao {

	int check(User user);

	boolean getUser(User user);

	int saveUser(User user);

	int createMovie(Theatre theatre);

	void update(int movieId);

	void delete(int movieId);

	List<Theatre> Theatre();

	int createTicket(Ticket ticket);

}
