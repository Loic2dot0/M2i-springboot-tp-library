package dev.loicmoreaux.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.loicmoreaux.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
