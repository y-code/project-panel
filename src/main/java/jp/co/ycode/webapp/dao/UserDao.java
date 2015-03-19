package jp.co.ycode.webapp.dao;

import java.util.List;

import jp.co.ycode.webapp.domain.User;

public interface UserDao {
	public List<User> getAll();
	public User getById(int userId);
	public User getByName(String name);
	public void save(User userId);
	public void delete(User user);
}
