package dev.loicmoreaux.library.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	private Long numberOfPages;
	
	@ManyToOne
	private Author author;
	
	@ManyToMany
	private List<Category> categories = new ArrayList<>();
	
	
	/**
	 * Constructors
	 */
	public Book() {}
	
	public Book(String title, Long numberOfPages) {
		this.title = title;
		this.numberOfPages = numberOfPages;
	}
	
	/**
	 * Getteres and Setters
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(Long numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	/**
	 * Methods
	 */
	public void addCategory(Category category) {
		this.categories.add(category);
	}	

}
