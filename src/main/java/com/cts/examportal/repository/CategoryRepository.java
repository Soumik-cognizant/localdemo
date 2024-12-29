package com.cts.examportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.examportal.model.exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
