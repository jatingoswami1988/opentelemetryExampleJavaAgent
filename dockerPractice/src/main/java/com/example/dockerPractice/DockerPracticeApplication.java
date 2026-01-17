package com.example.dockerPractice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.User;

@SpringBootApplication
@RestController
public class DockerPracticeApplication {
	
	private UserService service = new UserService();

	public static void main(String[] args) {
		SpringApplication.run(DockerPracticeApplication.class, args);
	}
	
	@GetMapping("/something")
	public ResponseEntity<String> createLogs() {
		//logger.warn("Just checking");
		return ResponseEntity.ok().body("All Ok");
	}
	
	Logger logger=LoggerFactory.getLogger(DockerPracticeApplication.class);

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable int id) {
		List<User> users= service.getAllUsers();
		User user=users.stream().filter(u->u.getId()==id).findAny().orElse(null);
		if(user!=null){
			logger.info("user found : {}",user);
			return user;
		}else{
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("User Not Found with ID : {}",id);
			}
			return new User();
		}
    }   

}
