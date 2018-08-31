package com.bharath.spring.springmvcorm.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bharath.spring.springmvcorm.user.entity.User;
import com.bharath.spring.springmvcorm.user.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private UserService service;

	@RequestMapping("registrationPage")
	public String showRegistrationPage() {
		return "userReg";
	}

	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user, ModelMap model) {
		int result = service.save(user);
		model.addAttribute("result", "User Created With Id" + result);

		return "userReg";
	}

	@RequestMapping("getUsers")
	public String getUser(ModelMap model) {
		List<User> users = service.getUsers();
		model.addAttribute("users", users);
		return "displayUsers";
	}

	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateUser(HttpServletRequest request,HttpServletResponse response) {
		String action=request.getParameter("action");
		if(action.equalsIgnoreCase("update")) {
			
			String[] ids=request.getParameterValues("id");
			String[] name=request.getParameterValues("name");
			String[] email=request.getParameterValues("email");
			
			for(int i=0; i<ids.length ; i++ ) {
				
				User user=hibernateTemplate.get(User.class,Integer.valueOf(ids[i]));
				user.setName(name[i]);
				user.setEmail(email[i]);
				hibernateTemplate.update(user);	
				
			}
					
		}
				
		return "displayUsers";
	}
	
	
	
	@RequestMapping("validateEmail")
	public @ResponseBody String validateEmail(@RequestParam("id") int id) {
		User user = service.getUser(id);
		String msg = "";

		if (user != null) {
			msg = id + " already exists";
		}
		return msg;

	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

}
