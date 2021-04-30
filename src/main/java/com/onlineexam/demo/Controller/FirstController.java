package com.onlineexam.demo.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.onlineexam.demo.Dao.QuestionDao;
//import com.onlineexam.demo.Dao.QuestionDao;
//import com.onlineexam.demo.Model.AppUser;
import com.onlineexam.demo.Model.Question;
import com.onlineexam.demo.Model.User;
import com.onlineexam.demo.Model.option;
import com.onlineexam.demo.Service.UserService;
import com.onlineexam.demo.utils.Constants;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@RestController
public class FirstController {

	@Autowired
	public UserService userService;
	@Autowired
	public QuestionDao questionDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView firstUrl() {
		ModelAndView first = new ModelAndView(); // first.addObject("loginUser", new LoginUser());
		first.setViewName("online-quiz");
		return first;
	}

	@RequestMapping(value = "/register form.html", method = RequestMethod.GET)
	public ModelAndView viewRegisterPage() {
		ModelAndView signUp = new ModelAndView("register form");
		signUp.addObject("user", new User());
		return signUp;

	}

	/*
	 * @RequestMapping(value = "/register", method = RequestMethod.POST)
	 * ModelAndView registerUser(@ModelAttribute("user") User user) { //
	 * model.addAttribute("login", new Login()); ModelAndView registerView = new
	 * ModelAndView(); userService.saveUser(user);
	 * registerView.setViewName("success"); return registerView; }
	 */

	@RequestMapping("/login.html")
	public ModelAndView viewLoginPage() {
		ModelAndView signUp = new ModelAndView("login");
		signUp.addObject("user", new User());
		return signUp;
	}


@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@RequestBody User user) {
		System.out.println(user);
		int returedrows = 0;
		returedrows = userService.saveUser(user);
		if ((user.getFirstname() != "") && (user.getLastname() != "")) {
			int value = userService.saveUser(user);
			String k;
			if (returedrows > 0) {
				k = "user created succesfully";
				System.out.println(value);
				System.out.println(k);
				return k;
			} else {
				k = "user already exists";
				System.out.println(k);
				return k;
			}
		} else {
			return "user not created";
		}

	}
	/*
	 * @RequestMapping(value = "/loginSuccess") public String
	 * loginSuccess(@RequestBody Principal principal) { String loginSuccess = new
	 * String();
	 * 
	 * System.out.println(principal.getName()); String roleName =
	 * userService.getRoleByName(principal.getName()); if
	 * (roleName.equalsIgnoreCase(Constants.role_user)) {
	 * System.out.println("user"); } else if
	 * (roleName.equalsIgnoreCase(Constants.role_admin)) {
	 * System.out.println("admin"); }
	 * 
	 * return loginSuccess; }
	 */
		

		/*
		 * @RequestMapping(value = "/Question", method = RequestMethod.GET)
		 * 
		 * @ResponseBody public List<option> display() { java.util.List<option>
		 * li=userService.getAllDocumentData1(); System.out.println(li); return (List)
		 * li; }
		 */
		@RequestMapping(value = "/Questions", method = RequestMethod.GET)
		public List<Question> display(@RequestParam("courseName") String courseName) {
			List<Question> li = userService.getAllDocumentData(courseName);
			System.out.println(li);
			return li;
		}
		 
			/*
			 * @RequestMapping(value = "/submit", method = RequestMethod.POST) public String
			 * submit(HttpServletRequest request ) { int score=0; String
			 * []question_ids=request.getParameterValues("question_id"); for(String
			 * question_id:question_ids){ //System.out.println(question_ids); int
			 * answerIdCorrect=userService.findAnswerIdCorrect(Integer.parseInt(question_id)
			 * ); if(answerIdCorrect==Integer.parseInt(request.getParameter("question_"+
			 * question_id))) { score++; } } return "question/result";
			 * 
			 * }
			 */
	}


