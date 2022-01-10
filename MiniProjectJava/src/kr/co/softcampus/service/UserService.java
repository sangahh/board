package kr.co.softcampus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.softcampus.dao.UserDao;

@Service
public class UserService {
	
	//사용할 수 있는 서비스인지 확인
	@Autowired
	private UserDao userDao;
	
	public boolean checkuserIdExist(String user_id) {
		
		String user_name = userDao.checkUserIdExist(user_id);
		
		if(user_name == null) {
			return true;
			
		} else {
			return false;
		}
	}
}
