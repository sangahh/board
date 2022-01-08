package kr.co.softcampus.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.softcampus.beans.UserBean;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		UserBean userBean = (UserBean)target;
		
		if(userBean.getUser_pw().equals(userBean.getUser_pw2()) == false) {
			errors.rejectValue("user_pw", "NotEquals");
			errors.reject("user_pw2", "NotEquals");
		}
	}
	
}
