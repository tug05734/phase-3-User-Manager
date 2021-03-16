package com.example.UserManager.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.UserManager.entities.User;
import com.example.UserManager.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	private int id;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/users")
	public String showUsers(ModelMap model){
		
		Iterable<User> users = userService.GetAllUsers();
		model.addAttribute("users", users);
		
		return "users";
	}
	
	@PostMapping(value="/edituser")
	public String showSearchedUser(ModelMap model, @RequestParam("id")String id) {
		logger.info("Entered id: " + id);
		this.id = Integer.parseInt(id);
		User user = userService.GetUserById(Integer.parseInt(id));
		if(user.isEmpty()) {
			model.addAttribute("userID" , id);
			return "edituserfail";
		}
		List<User> userList = new ArrayList<>();
		userList.add(user);
		model.addAttribute("users", userList);
		
		return "edituser";
	}
	
	@PostMapping(value="/process_update")
	public String updateUser(ModelMap model, @RequestParam("name")String name, @RequestParam("email")String email, @RequestParam("password")String password) {
	
		logger.info("id: " + id + " name: " + name + " email: " + email + " password: " + password);
		if(!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			model.addAttribute("user", user.getName());
			userService.updateUser(user);
			
			return "updateresult";
		} 
		
		return "updateresultfail";
	}
	
}
