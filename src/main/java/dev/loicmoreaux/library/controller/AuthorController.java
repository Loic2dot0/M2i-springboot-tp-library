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

import dev.loicmoreaux.library.entity.Author;
import dev.loicmoreaux.library.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/")
	public ResponseEntity<List<Author>> getAllAuthors(){
		return ResponseEntity.ok(authorService.getAllAuthors());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAuthorById(@PathVariable("id") Integer id){
		Optional<Author> optionalAuthor = authorService.getAuthorById(id);
		
		if(optionalAuthor.isPresent()) return ResponseEntity.ok(optionalAuthor.get());
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/")
	public ResponseEntity<Author> createAuthor(@RequestBody Author author){
		Author authorCreated = authorService.saveAuthor(author);
		
		return new ResponseEntity<Author>(authorCreated, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateAuthor(@PathVariable("id") Integer id, @RequestBody Author modifiedAuthor){
		if(id == null || id != modifiedAuthor.getId()) return ResponseEntity.badRequest().build();
		
		Optional<Author> optionalAuthor = authorService.getAuthorById(id);
		
		if(optionalAuthor.isPresent()) return ResponseEntity.ok(authorService.updateAuthor(modifiedAuthor));
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAuthor(@PathVariable("id") Integer id){
		Optional<Author> optionalAuthor = authorService.getAuthorById(id);
		
		if(optionalAuthor.isPresent()) {
			authorService.deleteAuthor(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
