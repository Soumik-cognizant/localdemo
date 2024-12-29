// package com.cts.examportal.service.impl;

// import java.util.Set;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.cts.examportal.helper.UserFoundException;
// import com.cts.examportal.model.User;
// import com.cts.examportal.model.UserRole;
// import com.cts.examportal.repository.RoleRepository;
// import com.cts.examportal.repository.UserRepository;
// import com.cts.examportal.service.UserService;

// @Service
// public class UserServiceImpl implements UserService {

// @Autowired
// private UserRepository userRepository;

// @Autowired
// private RoleRepository roleRepository;

// //creating user
// @Override
// public User createUser(User user, Set<UserRole> userRoles) throws Exception {

// User local = this.userRepository.findByUsername(user.getUsername());
// if (local != null) {
// System.out.println("User is already there !!");
// throw new UserFoundException();
// } else {
// //user create
// for (UserRole ur : userRoles) {
// roleRepository.save(ur.getRole());
// }

// user.getUserRoles().addAll(userRoles);
// local = this.userRepository.save(user);

// }

// return local;
// }

// //getting user by username
// @Override
// public User getUser(String username) {
// return this.userRepository.findByUsername(username);
// }

// @Override
// public void deleteUser(Long userId) {
// this.userRepository.deleteById(userId);
// }

// /* @Override
// public User getUser(Long userId) {
// return this.userRepository.findById(userId).orElseThrow(() -> new
// UserNotFoundException("User not found with id: " + userId));
// }

// @Override
// public User updateUser(User user) {
// try {
// User existingUser = userRepository.findById(user.getId()).orElseThrow(() ->
// new UserNotFoundException("User not found with id: " + user.getId()));
// existingUser.setUsername(user.getUsername()); // Update username if provided
// existingUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
// // Encode password before update
// // Update other user fields as needed
// return userRepository.save(existingUser);

// } catch (UserNotFoundException e) {
// // Handle the exception here (e.g., log the error)
// log.error("User not found during update: {}", e.getMessage());
// throw e; // Re-throw the exception to be handled at a higher level
// }

// }*/

// }
