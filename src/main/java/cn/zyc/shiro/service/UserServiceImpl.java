package cn.zyc.shiro.service;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zyc.shiro.dao.UserDAO;
import cn.zyc.shiro.model.Result;
import cn.zyc.shiro.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public List<User> getUser(User user) {
		return userDAO.getUser(user);
	}

	public List<Result> userInfo(User user) {
		return userDAO.userInfo(user);
	}

	public User loadInfo(User user) {
		return userDAO.loadInfo(user);
	}

	public User getCurrentUser() {
		final Long id = (Long) SecurityUtils.getSubject().getPrincipal();
		if (id != null) {
			User param = new User();
			param.setId(id);
			List<User> info = getUser(param);
			return info.get(0);
		} else {
			return null;
		}

	}

	@Override
	public Long createUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		// user.setPassword(password);
		user.setPassword(new Sha256Hash(password).toHex());
		return userDAO.insert(user);
	}
}
