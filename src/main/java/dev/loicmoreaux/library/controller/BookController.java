package dev.loicmoreaux.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.loicmoreaux.library.entity.Book;
import dev.loicmoreaux.library.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public ResponseEntity<List<Book>> getAllBooks(){
		return ResponseEntity.ok(bookService.getAllBooks());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBookId(@PathVariable("id") Integer id){
		Optional<Book> optionalBook = bookService.getBookById(id);
		
		if(optionalBook.isPresent()) return ResponseEntity.ok(optionalBook.get());
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/")
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		Book bookCreated = bookService.saveBook(book);
		
		return new ResponseEntity<Book>(bookCreated, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateBook(@PathVariable("id") Integer id, @RequestBody Book modifiedBook){
		if(id == null || id != modifiedBook.getId()) return ResponseEntity.badRequest().build();
		
		Optional<Book> optionalBook = bookService.getBookById(id);
		
		if(optionalBook.isPresent()) return ResponseEntity.ok(bookService.updateBook(modifiedBook));
		
		return ResponseEntity.notFound().build();
	}
}
