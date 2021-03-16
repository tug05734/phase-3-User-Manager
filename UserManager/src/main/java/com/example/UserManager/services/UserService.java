package com.example.UserManager.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.UserManager.entities.User;
import com.example.UserManager.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	private User user = new User();
	
	public Iterable<User> GetAllUsers(){
		return userRepository.findAll();
	}
	
	public User GetUserByName(String name) {
		User foundUser = userRepository.findByName(name);
		return foundUser;
	}
	
	public User GetUserById(int id) {
    	Optional<User> foundUser = userRepository.findById(id);
    	if(!foundUser.isPresent()) {
    		return user;
    	}
    	return(foundUser.get());
    }
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
}
