package jp.co.ycode.webapp.dao.hibernate;

import java.util.List;

import jp.co.ycode.webapp.dao.UserDao;
import jp.co.ycode.webapp.domain.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from User").list();
	}

	@Override
	@Transactional(readOnly = true)
	public User getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (User) session.get(User.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public User getByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		return (User) session
				.createQuery("from User u where u.name = :name")
				.setString("name", name)
				.uniqueResult();
	}

	@Override
	public void save(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(user);
	}

	@Override
	public void delete(User user) {
		this.sessionFactory.getCurrentSession().delete(user);
	}
	
}
