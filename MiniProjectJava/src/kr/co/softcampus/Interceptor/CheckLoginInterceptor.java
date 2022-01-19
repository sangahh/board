package kr.co.softcampus.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.softcampus.beans.UserBean;

public class CheckLoginInterceptor implements HandlerInterceptor{
	
	//로그인여부값으로 따져야하기때문에 LoginUserBean을 사용함.
	//자바프로젝트에서 Interceptor는 Bean을 주입받지못하기때문에 생성자로 받음.
	private UserBean loginUserBean;
	
	public CheckLoginInterceptor(UserBean loginUserBean) {
		
		this.loginUserBean = loginUserBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//로그인 안했을 경우
		if(loginUserBean.isUserLogin() == false) {
			String contextPath = request.getContextPath();
			//웹브라우저에게 요청
			response.sendRedirect(contextPath + "/user/not_login");
			return false;
		} 
		return true;
	}
	
}
