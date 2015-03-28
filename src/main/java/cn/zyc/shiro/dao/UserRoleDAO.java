package cn.zyc.shiro.dao;

import java.util.List;

import cn.zyc.shiro.model.Role;

public interface UserRoleDAO {

	List<Role> queryRoleByUid(Long rid);
}
