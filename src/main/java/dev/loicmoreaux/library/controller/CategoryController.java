package dev.loicmoreaux.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.loicmoreaux.library.entity.Category;
import dev.loicmoreaux.library.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public ResponseEntity<List<Category>> getAllCategories(){
		return ResponseEntity.ok(categoryService.getAllCategories());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable("id") Integer id){
		Optional<Category> optionalCategory = categoryService.getCategoryById(id);
		
		if(optionalCategory.isPresent()) return ResponseEntity.ok(optionalCategory.get());
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/")
	public ResponseEntity<Category> createCategory(@RequestBody Category category){
		Category categoryCreated = categoryService.saveCategory(category);
		
		return new ResponseEntity<Category>(categoryCreated, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable("id") Integer id, @RequestBody Category modifiedCategory){
		if(id == null || id != modifiedCategory.getId()) return ResponseEntity.badRequest().build();
		
		Optional<Category> optionalCategory = categoryService.getCategoryById(id);
		
		if(optionalCategory.isPresent()) return ResponseEntity.ok(categoryService.updateCategory(modifiedCategory));
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable("id") Integer id){
		Optional<Category> optionalCategory = categoryService.getCategoryById(id);
		
		if(optionalCategory.isPresent()) {
			categoryService.deleteCategory(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
