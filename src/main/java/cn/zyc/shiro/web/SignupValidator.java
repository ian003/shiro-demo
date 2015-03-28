package cn.zyc.shiro.web;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SignupValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return SignupCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
				"error.username.empty", "Please specify a username.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"error.password.empty", "Please specify a password.");
	}

}
