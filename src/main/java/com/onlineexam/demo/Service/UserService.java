package com.onlineexam.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.onlineexam.demo.Dao.AppUserDAO;
import com.onlineexam.demo.Dao.QuestionDao;
import com.onlineexam.demo.Model.AppUser;
import com.onlineexam.demo.Model.Questions;
import com.onlineexam.demo.Model.User;
import com.onlineexam.demo.UserRepository.UserRepository;
@Service
public class UserService {
	
	@Autowired
	private AppUserDAO appuserdao;
	
	@Autowired 
	private UserRepository userRepository;
	@Autowired
	private QuestionDao questiondao  ;
	
	
	public int saveUser(User user) {
		int savedUser = userRepository.saveUser(user);
		//savedUniqueId = savedUser;
		//updateUserApp(user,savedUser);
		return savedUser;
	}
//	JSONArray.fromObject(userService.getUserList())


	public Object getUserList() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getRoleByName(String name) {
		String roleName = appuserdao.findRoleByName(name);
		return roleName;
	}

	/*
	 * public Long UserApp(User user,int uniqueId) { Long appUniqueId =(long) 0;
	 * if(uniqueId >0) { String encodedPwd = getEncodedPassword(user.getPassword());
	 * user.setPassword(encodedPwd); user.setEnabled(true);
	 * appUniqueId=userRepository.saveUserAppDetails(user); } if(appUniqueId > 0) {
	 * Long uniqueUserId = updateUserRole(appUniqueId); } return appUniqueId; }
	 * public String getEncodedPassword(String pwd) { return
	 * EncrytedPasswordUtils.encrytePassword(pwd); }
	 * 
	 */
public List<Questions> getAllQuestionsData() {
	List<Questions> q1 = questiondao.getAllQuestionsData();
	
	return q1;
}

}
