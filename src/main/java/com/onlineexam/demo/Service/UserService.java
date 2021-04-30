package com.onlineexam.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.onlineexam.demo.Dao.AppUserDAO;
import com.onlineexam.demo.Dao.QuestionDao;
import com.onlineexam.demo.Model.AppUser;
import com.onlineexam.demo.Model.Question;
import com.onlineexam.demo.Model.User;
import com.onlineexam.demo.Model.option;
import com.onlineexam.demo.UserRepository.UserRepository;
import com.onlineexam.demo.utils.EncrytedPasswordUtils;
@Service
public class UserService {
	
	@Autowired
	private AppUserDAO appuserdao;
	
	@Autowired 
	private UserRepository userRepository;
	@Autowired 
	private QuestionDao questionDao;
	
	
	public int saveUser(User user) {
		int savedUser = userRepository.saveUser(user);
		//savedUniqueId = savedUser;
		//updateUserApp(user,savedUser);
		return savedUser;
	}
	
	
//	JSONArray.fromObject(userService.getUserList())


	/*
	 * public Object getUserList() { // TODO Auto-generated method stub return null;
	 * }
	 * 
	 * 
	 * public String getRoleByName(String name) { String roleName =
	 * appuserdao.findRoleByName(name); return roleName; }
	 */

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
	/*
	 * public Long updateUserApp(User user, int uniqueId) { Long appUniqueId =
	 * (long) 0; if (uniqueId > 0) { String encodedPwd =
	 * getEncodedPassword(user.getpassword()); user.setpassword(encodedPwd);
	 * user.setEnabled(true); appUniqueId = userRepository.saveUserAppDetails(user);
	 * } if (appUniqueId > 0) { Long uniqueUserId = updateUserRole(appUniqueId); }
	 * return appUniqueId; }
	 */

	public String getEncodedPassword(String pwd) {
		return EncrytedPasswordUtils.encrytePassword(pwd);
	}
	/*
	 * public Long updateUserRole(Long appUniqueId) { int longValue =
	 * appUniqueId.intValue(); int roleId = 2; Long uniqueUserId =
	 * userRepository.saveUserRole(longValue, roleId); return uniqueUserId; }
	 */


	public String getRoleByName(String name) {
		String roleName = appuserdao.findRoleByName(name);
		return roleName;
	}

	/*
	 * public List<Question> getAllDocumentData() { List<Question> documentList =
	 * questionDao.getAllDocumentData(); return documentList;
	 */
	//}
	/*
	 * public List<option> getAllDocumentData1() { List<option> documentList1 =
	 * questionDao.getAllDocumentData(); return documentList1; }
	 */


	/*
	 * public int findAnswerIdCorrect(int questionId) { Question
	 * question=QuestionDao.findById(questionId).get(); for(Answer
	 * answer:Question.getAnswers())){ if(answer.isCorrect()) { return
	 * answer.getId(); } }
	 */
		
		//return -1;
	public List<Question> getAllDocumentData(String course_name) {
		List<Question> questionsList = questionDao.getAllDocumentData(course_name);
		for(Question questionId : questionsList) {
			List<option> optionsList=questionDao.getOptionsById(questionId.getQuestion_Id());
			questionId.setOptions(optionsList);
		}
		return questionsList;
	}
		
}





