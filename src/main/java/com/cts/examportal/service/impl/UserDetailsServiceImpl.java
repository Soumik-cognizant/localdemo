package com.cts.examportal.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.cts.examportal.model.User;
import com.cts.examportal.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  /*  @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("No user found !!");
        }
        1.wrong pass in handeler
        2.user details service impl

        return user;
    }*/
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@Override 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		User user = this.userRepository.findByUsername(username); 
		if (user == null) { 
			System.out.println("User not found");
			throw new UsernameNotFoundException("No user found !!");
		}

		
		return user; 
		}
}
	

