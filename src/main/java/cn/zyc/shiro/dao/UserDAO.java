package cn.zyc.shiro.dao;

import java.util.List;

import cn.zyc.shiro.model.Result;
import cn.zyc.shiro.model.User;

public interface UserDAO {

	List<User> getUser(User user);

	List<Result> userInfo(User user);

	User loadInfo(User user);
	
	Long insert(User user);
}
