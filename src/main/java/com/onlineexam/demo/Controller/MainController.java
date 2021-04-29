package com.onlineexam.demo.Controller;

import java.security.Principal;



import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlineexam.demo.utils.WebUtils;


 
@Controller
public class MainController {
 
	/*
	 * @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	 * public String welcomePage(Model model) { model.addAttribute("title",
	 * "Welcome"); model.addAttribute("message", "This is welcome page!"); return
	 * "welcomePage"; }
	 */
 
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {
         
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        String userInfo = com.onlineexam.demo.utils.WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
         
        return "adminPage";
    }
 
	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.GET) public String
	 * loginPage(Model model) {
	 * 
	 * return "loginPage"; }
	 */
 
    
 
    
    
 
}
