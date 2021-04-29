package com.onlineexam.demo.Controller;

import java.util.List;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.onlineexam.demo.Dao.QuestionDao;
import com.onlineexam.demo.Model.AppUser;
import com.onlineexam.demo.Model.Questions;
import com.onlineexam.demo.Model.User;
import com.onlineexam.demo.Service.UserService;
import com.onlineexam.demo.utils.Constants;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@RestController
public class FirstController {

	@Autowired
	public UserService userService;
	

	@RequestMapping(value = "/home", method = RequestMethod.GET)
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
		int returedrows = 0;
		returedrows = userService.saveUser(user);
		
		
//		  if(user.getFirstname().isEmpty() ||user.getLastname().isEmpty() ||
//		 user.getPhone_number().isEmpty() ||user.getPassword().isEmpty()) {
//		 System.out.println("user not created"); } else { System.out.println(user);
//		  returedrows=userService.saveUser(user); System.out.println("user created"); }
//	
		if(returedrows>0) {
			return "user created";
		}else {
			return "user not created";
		}
	}

 //@RequestMapping(path="/questions", method = RequestMethod.POST)

//              public String questionsDisplay(@RequestBody Questions question){
//            List<Questions> questions=userService.getAllQuestionsData();
//            for(Questions q: questions) 
//            	System.out.println("q");
// return questions;
	 @RequestMapping(value = "/questions",method = RequestMethod.GET)      
	 @ResponseBody
	 public List display()
	 {
		java.util.List<Questions> li =userService.getAllQuestionsData();
		 System.out.println(li);
		 return (List) li;
	 }
	 
//	 @RequestMapping(path = "/submit", method = RequestMethod.GET)
//			    public QuestionDao createSimpleDto(
//
//			      @Validated @RequestBody User simpleDto) {
//
//		 QuestionDao result = UserService.saveUser(simpleDto);
//			    return result;
//
//			  }
	 
	 
		@RequestMapping(value = "/loginSuccess")
		public String loginSuccess(@RequestBody Principal principal) {
			String loginSuccess = new String();
			
			System.out.println(principal.getName());
			String roleName = userService.getRoleByName(principal.getName());
			if (roleName.equalsIgnoreCase(Constants.role_user)) {
			System.out.println("user");
			} else if (roleName.equalsIgnoreCase(Constants.role_admin)) {
				System.out.println("admin");
			}

			return loginSuccess;
		}
		
	}


