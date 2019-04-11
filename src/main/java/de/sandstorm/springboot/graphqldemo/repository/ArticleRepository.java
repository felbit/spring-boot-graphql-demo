package de.sandstorm.springboot.graphqldemo.repository;

import de.sandstorm.springboot.graphqldemo.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> { }
