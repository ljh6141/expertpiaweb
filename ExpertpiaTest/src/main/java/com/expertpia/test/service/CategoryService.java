package com.expertpia.test.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expertpia.test.domain.Category;
import com.expertpia.test.repository.CategoryRepository;

@Transactional
@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getlist(){
		return categoryRepository.findAll();
	}
	public Category getCategory(Long id){
		Category getId=categoryRepository.findOne(id);
		return getId;
	}
	public Category create(Category category){
		categoryRepository.save(category);
		return category;
	}
	public Category update(Long id, Category category){
		category.setCateId(id);
		categoryRepository.save(category);
		return category;
	}
	public Category delete(Long id){
		Category category=categoryRepository.findOne(id);
		categoryRepository.delete(category);
		return category;
	}
}
