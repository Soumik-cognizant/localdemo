package com.cts.examportal.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.cts.examportal.config.JwtUtils;
import com.cts.examportal.helper.InvalidCredentialsException;
import com.cts.examportal.helper.UserDisabledException;
import com.cts.examportal.helper.UserNotFoundException;
import com.cts.examportal.model.JwtRequest;
import com.cts.examportal.model.JwtResponse;
import com.cts.examportal.model.User;
import com.cts.examportal.service.impl.UserDetailsServiceImpl;

import java.security.Principal;

@RestController
public class AuthenticateController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;


    //generate token

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        try {

            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());


        } catch (UserNotFoundException e) {
            e.printStackTrace();
            throw new Exception("User not found ");
        }

        /////////////authenticate

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
       // String token = this.jwtUtils.generateToken(userDetails);
        String token = this.jwtUtils.generateToken(jwtRequest.getUsername());
        return ResponseEntity.ok(new JwtResponse(token));


    }

    
    private void authenticate(String username, String password) throws Exception {

      /*  try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        } catch (DisabledException e) {
            throw new Exception("USER DISABLED " + e.getMessage());
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid Credentials " + e.getMessage());
        }*/
    	
    	  try {
    	        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    	    } catch (DisabledException e) {
    	        throw new UserDisabledException("USER DISABLED: " + e.getMessage());
    	    } catch (BadCredentialsException e) {
    	        throw new InvalidCredentialsException("Invalid Credentials: " + e.getMessage());
    	    }
    }

    //return the details of current user
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal) {
        return ((User) this.userDetailsService.loadUserByUsername(principal.getName()));

    }



}
