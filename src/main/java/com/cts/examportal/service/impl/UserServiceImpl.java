package com.cts.examportal.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.examportal.helper.UserFoundException;
import com.cts.examportal.helper.UserNotFoundException;
import com.cts.examportal.model.User;
import com.cts.examportal.model.UserRole;
import com.cts.examportal.repository.RoleRepository;
import com.cts.examportal.repository.UserRepository;
import com.cts.examportal.service.UserService;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private BCryptPasswordEncoder encoder;

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {


        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User is already there !!");
            throw new UserFoundException();
        } else {
            //user create
            for (UserRole ur : userRoles) {
            	roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);

        }

        return local;
    }

    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

	@Override
	public User updateUser(Long id,User user) throws UserNotFoundException  {
		// TODO Auto-generated method stub
		//return this.userRepository.save(user);
		User localuser=this.userRepository.findById(id).orElseThrow(()-> new UserNotFoundException());
		
		if(user.getUsername()!= null) {
			localuser.setUsername(user.getUsername());
		}
		
		if(user.getPassword() != null) {
			localuser.setPassword(encoder.encode(user.getPassword()));
		}
		
		if(user.getFirstName() != null) {
			localuser.setFirstName(user.getFirstName());
		}
		
		if(user.getLastName() != null) {
			localuser.setLastName(user.getLastName());
		}
		
		if(user.getEmail() != null) {
			localuser.setEmail(user.getEmail());
		}
		if(user.getPhone() != null) {
			localuser.setPhone(user.getPhone());
		}
		
		
		return this.userRepository.save(localuser);
		
		
		
		
		
		
	}
    
 


}
