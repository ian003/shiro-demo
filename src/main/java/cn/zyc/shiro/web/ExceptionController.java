package cn.zyc.shiro.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExceptionController {

	@RequestMapping(value = "/unauthenticated.do", method = RequestMethod.GET)
	public String unauthenticated() {
		return "unauthenticated";
	}

	@RequestMapping(value = "/unauthorized.do", method = RequestMethod.GET)
	public String unauthorized() {
		return "unauthorized";
	}
}
