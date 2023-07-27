package dev.loicmoreaux.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.loicmoreaux.library.dao.BookRepository;
import dev.loicmoreaux.library.entity.Book;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public Optional<Book> getBookById(Integer id){
		return bookRepository.findById(id);
	}
	
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	
	public void deleteBook(Integer id) {
		bookRepository.deleteById(id);
	}
	
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
}
