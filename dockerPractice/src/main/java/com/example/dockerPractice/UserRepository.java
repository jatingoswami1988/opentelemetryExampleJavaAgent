package com.example.dockerPractice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.entities.User;

public class UserRepository {

	public List<User> getUsers() {
        return Stream.of(new User(1, "John"),
				new User(2, "Shyam"),
				new User(3, "Rony"),
				new User(4, "mak"))
				.collect(Collectors.toList());
    }
}
