package com.expertpia.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expertpia.test.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
