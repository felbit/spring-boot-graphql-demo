package de.sandstorm.springboot.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import de.sandstorm.springboot.graphqldemo.model.Article;
import de.sandstorm.springboot.graphqldemo.model.Author;
import de.sandstorm.springboot.graphqldemo.repository.ArticleRepository;
import de.sandstorm.springboot.graphqldemo.repository.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    private ArticleRepository articleRepository;

    private AuthorRepository authorRepository;

    public Query(ArticleRepository articleRepository, AuthorRepository authorRepository) {
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
    }

    public Optional<Article> article(Long id) {
        return articleRepository.findById(id);
    }

    public Iterable<Article> findAllArticles() {
        return articleRepository.findAll();
    }

    public Optional<Author> author(Long id) {
        return authorRepository.findById(id);
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

}
