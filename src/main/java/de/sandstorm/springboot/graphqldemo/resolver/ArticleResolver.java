package de.sandstorm.springboot.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import de.sandstorm.springboot.graphqldemo.model.Article;
import de.sandstorm.springboot.graphqldemo.model.Author;
import de.sandstorm.springboot.graphqldemo.repository.AuthorRepository;
import org.springframework.stereotype.Component;

@Component
public class ArticleResolver implements GraphQLResolver<Article> {

    private AuthorRepository authorRepository;

    public ArticleResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Article article) {
        return authorRepository.findById(article.getAuthor().getId()).orElse(null);
    }
}
