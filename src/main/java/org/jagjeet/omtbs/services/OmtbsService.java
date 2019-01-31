package org.jagjeet.omtbs.services;

import java.util.List;

import org.jagjeet.omtbs.model.Theatre;
import org.jagjeet.omtbs.model.Ticket;
import org.jagjeet.omtbs.model.User;

public interface OmtbsService {

	int check(User user);

	boolean getUser(User user);

	int saveUser(User user);

	int saveMovie(Theatre theatre);

	int edit(int movieId);

	int remove(int movieId);

	List<Theatre> Theatre();

	int saveTicket(Ticket ticket);

}
