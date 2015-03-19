package jp.co.ycode.webapp.domain.service.live;

import java.security.Principal;
import java.util.List;

import jp.co.ycode.webapp.dao.UserDao;
import jp.co.ycode.webapp.domain.User;
import jp.co.ycode.webapp.domain.UserRole;
import jp.co.ycode.webapp.domain.service.UserMgmtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMgmtServiceImpl implements UserMgmtService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getAllUsers() {
		return userDao.getAll();
	}

	@Override
	public User getUserById(int id) {
		return userDao.getById(id);
	}

	@Override
	public void signupUser(User user) {
		//Set up default user role.
		user.setEnabled(true);
		user.getUserRoles().add(new UserRole(user, UserRole.Role.GENERAL));
		
		userDao.save(user);
	}

	@Override
	public User getUserByPrincipal(Principal principal) {
		return userDao.getByName(principal.getName());
	}
	
}
