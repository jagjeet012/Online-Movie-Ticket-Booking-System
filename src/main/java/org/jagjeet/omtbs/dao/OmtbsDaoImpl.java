package org.jagjeet.omtbs.dao;

import java.util.List;

import org.jagjeet.omtbs.model.Theatre;
import org.jagjeet.omtbs.model.Ticket;
import org.jagjeet.omtbs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OmtbsDaoImpl implements OmtbsDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public int check(User user) {

		Object[] params = { user.getUserName(), user.getPassword() };
		List list = hibernateTemplate.find("from User where userName = " + "'" + user.getUserName() + "'"
				+ " and password = " + "'" + user.getPassword() + "'");

		if (list.size() > 0) {
			User u = (User) list.get(0);
			user.setId(u.getId());
			return 1;
		}
		return 0;
	}

	@Override
	public boolean getUser(User user) {
		String query = "from User where userName = " + "'" + user.getUserName() + "'" + " and password = " + "'"
				+ user.getPassword() + "'";

		List<User> userList = (List<User>) hibernateTemplate.find(query);
		if (userList.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public int saveUser(User user) {
		Integer result = (Integer) hibernateTemplate.save(user);
		return result;
	}

	@Override
	public int createMovie(Theatre theatre) {

		Integer result = (Integer) hibernateTemplate.save(theatre);
		return result;

	}

	@Override
	public void update(int movieId) {
		hibernateTemplate.update(movieId);

	}

	@Override
	public void delete(int movieId) {
		hibernateTemplate.delete(movieId);
	}

	@Override
	public List<org.jagjeet.omtbs.model.Theatre> Theatre() {

		return hibernateTemplate.loadAll(Theatre.class);
	}

	@Override
	public int createTicket(Ticket ticket) {
		Integer result = (Integer) hibernateTemplate.save(ticket);
		return result;
	}

}
