package com.cts.examportal.service;

//import com.exam.helper.UserNotFoundException;



import java.util.Set;

import com.cts.examportal.model.User;
import com.cts.examportal.model.UserRole;

public interface UserService {

    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by userName
    public User getUser(String username);

    //delete user by id
    public void deleteUser(Long userId);


    
    
    
}
