package cn.zyc.shiro.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zyc.shiro.service.UserService;

@Controller
public class ManageUsersController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/manageUser.do")
	@RequiresPermissions("user:manage")
	public void manageUsers(Model model) {
		model.addAttribute("users", userService.getUser(null));
	}

}
