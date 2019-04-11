package de.sandstorm.springboot.graphqldemo.repository;

import de.sandstorm.springboot.graphqldemo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> { }
