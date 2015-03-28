package cn.zyc.shiro.service;

import java.util.List;

import cn.zyc.shiro.model.Result;
import cn.zyc.shiro.model.User;

public interface UserService {
	List<User> getUser(User user);

	List<Result> userInfo(User user);

	User loadInfo(User user);

	User getCurrentUser();

	Long createUser(String username, String password);
}
