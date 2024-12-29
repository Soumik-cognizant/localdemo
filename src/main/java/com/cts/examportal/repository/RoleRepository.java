package com.cts.examportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.examportal.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
