package jp.co.ycode.webapp.domain.service;

import java.security.Principal;
import java.util.List;

import jp.co.ycode.webapp.domain.User;

public interface UserMgmtService {
	public List<User> getAllUsers();
	public User getUserById(int userId);
	public User getUserByPrincipal(Principal principal);
	public void signupUser(User user);
}
