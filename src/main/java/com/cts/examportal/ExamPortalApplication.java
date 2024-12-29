package com.cts.examportal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cts.examportal.helper.UserFoundException;
import com.cts.examportal.model.Role;
import com.cts.examportal.model.User;
import com.cts.examportal.model.UserRole;
import com.cts.examportal.repository.QuizRepository;
import com.cts.examportal.service.UserService;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner {
	
	  @Autowired
	    private UserService userService;

	    @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;

	    @Autowired
	    public QuizRepository quizRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}
	
	  @Override
	    public void run(String... args) throws Exception {
	        try {


	            System.out.println("starting code");
	//
	            User user = new User();

	            user.setFirstName("Soumik");
	            user.setLastName("Das");
	            user.setUsername("soumik8896");
	            user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
	            user.setEmail("abc@gmail.com");
	            user.setProfile("default.png");

	            Role role1 = new Role();
	            role1.setRoleId(44L);
	            role1.setRoleName("ADMIN");

	            Set<UserRole> userRoleSet = new HashSet<>();
	            UserRole userRole = new UserRole();

	            userRole.setRole(role1);

	            userRole.setUser(user);

	            userRoleSet.add(userRole);

	            User user1 = this.userService.createUser(user, userRoleSet);
	            System.out.println(user1.getUsername());


	        } catch (UserFoundException e) {
	            e.printStackTrace();


	        }


	    }

}

