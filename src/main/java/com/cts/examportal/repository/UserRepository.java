package com.cts.examportal.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.examportal.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
