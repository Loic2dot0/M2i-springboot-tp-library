package dev.loicmoreaux.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.loicmoreaux.library.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
