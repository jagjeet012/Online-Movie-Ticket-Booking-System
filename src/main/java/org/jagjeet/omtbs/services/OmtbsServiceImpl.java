package org.jagjeet.omtbs.services;

import java.util.List;

import org.jagjeet.omtbs.dao.OmtbsDao;
import org.jagjeet.omtbs.model.Theatre;
import org.jagjeet.omtbs.model.Ticket;
import org.jagjeet.omtbs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OmtbsServiceImpl implements OmtbsService {

	@Autowired
	private OmtbsDao dao;

	public OmtbsDao getDao() {
		return dao;
	}

	public void setDao(OmtbsDao dao) {
		this.dao = dao;
	}

	@Override
	public int check(User user) {
		return dao.check(user);
	}

	@Override
	public boolean getUser(User user) {
		return dao.getUser(user);
	}

	@Override
	@Transactional
	public int saveUser(User user) {
		return dao.saveUser(user);
	}

	@Override
	@Transactional
	public int saveMovie(Theatre theatre) {
		return dao.createMovie(theatre);
	}

	@Override
	public int edit(int movieId) {
		try {
			dao.update(movieId);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int remove(int movieId) {
		try {
			dao.delete(movieId);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public List<org.jagjeet.omtbs.model.Theatre> Theatre() {
		return dao.Theatre();
	}

	@Override
	@Transactional
	public int saveTicket(Ticket ticket) {
		return dao.createTicket(ticket);
	}
}
