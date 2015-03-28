package cn.zyc.shiro.security;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.zyc.shiro.dao.UserDAO;
import cn.zyc.shiro.model.Role;
import cn.zyc.shiro.model.User;

@Component
public class ShiroRealm extends AuthorizingRealm {

	protected UserDAO userDAO;

	private CacheManager cacheManager;

	@Autowired
	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public ShiroRealm() {
		setName("ShiroRealm");
		// setCredentialsMatcher(new Sha256CredentialsMatcher());

		HashedCredentialsMatcher hcm = new HashedCredentialsMatcher();
		hcm.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);// 密码匹配规则,可以是MD5或者SHA-1，如果对密码安全有更高要求可以用SHA-256或者更高
		setCredentialsMatcher(hcm);

	}

	/** 认证 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {

		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		// TODO token中储存着输入的用户名和密码，然后与数据库中的进行比对;
		User param = new User();
		param.setUsername(token.getUsername());
		List<User> users = userDAO.getUser(param);
		if (users.size() != 0) {
			User user = users.get(0);
			if (user != null) {
				return new SimpleAuthenticationInfo(user.getId(),
						user.getPassword(), getName());
			} else {
				return null;
			}
		} else {
			return null;
		}

	}

	/** 授权 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		Long userId = (Long) principals.fromRealm(getName()).iterator().next();
		User param = new User();
		param.setId(userId);
		User user = userDAO.loadInfo(param);
		if (user != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			for (Role role : user.getRoles()) {
				info.addRole(role.getName());
				info.setStringPermissions(role.getPermissions());
			}
			return info;
		} else {
			return null;
		}
	}

}
