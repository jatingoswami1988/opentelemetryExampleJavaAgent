package com.example.dockerPractice;

import java.util.List;

import com.example.entities.User;

public class UserService {

	private UserRepository repository = new UserRepository();

	public List<User> getAllUsers() {
		return repository.getUsers();
	}
}
