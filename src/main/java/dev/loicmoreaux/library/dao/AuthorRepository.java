package dev.loicmoreaux.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.loicmoreaux.library.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
