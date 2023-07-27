package dev.loicmoreaux.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.loicmoreaux.library.dao.CategoryRepository;
import dev.loicmoreaux.library.entity.Category;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
	
	public Optional<Category> getCategoryById(Integer id){
		return categoryRepository.findById(id);
	}
	
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);		
	} 
	
	public void deleteCategory(Integer id) {
		categoryRepository.deleteById(id);
	}
	
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);		
	} 

}
