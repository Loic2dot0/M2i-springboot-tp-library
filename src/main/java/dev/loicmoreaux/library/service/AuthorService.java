package dev.loicmoreaux.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.loicmoreaux.library.dao.AuthorRepository;
import dev.loicmoreaux.library.entity.Author;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public List<Author> getAllAuthors(){
		return authorRepository.findAll();
	}
	
	public  Optional<Author> getAuthorById(Integer id){
		return authorRepository.findById(id);
	}
	
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}
	
	public void deleteAuthor(Integer id) {
		authorRepository.deleteById(id);
	}
}
