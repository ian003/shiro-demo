package cn.zyc.shiro.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.zyc.shiro.model.User;
import cn.zyc.shiro.service.UserService;

@Component("currentUserInterceptor")
public class CurrentUserInterceptor extends HandlerInterceptorAdapter {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		User currentUser = userService.getCurrentUser();
		if (currentUser != null) {
			request.setAttribute("currentUser", currentUser);
		}

	}

}
