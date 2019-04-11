package de.sandstorm.springboot.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import de.sandstorm.springboot.graphqldemo.model.Article;
import de.sandstorm.springboot.graphqldemo.model.Author;
import de.sandstorm.springboot.graphqldemo.repository.ArticleRepository;
import de.sandstorm.springboot.graphqldemo.repository.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private ArticleRepository articleRepository;
    private AuthorRepository authorRepository;

    public Mutation(ArticleRepository articleRepository, AuthorRepository authorRepository) {
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
    }

    public Article newArticle(String title, String text, Long authorId) {
        Article article = new Article();
        article.setTitle(title);
        article.setText(text);
        article.setAuthor(new Author(authorId));

        articleRepository.save(article);

        return article;
    }

    public Optional<Article> updateArticle(Long id, String title, String text, Long authorId) {
        Optional<Article> article = articleRepository.findById(id);

        article.ifPresent(a -> {
            a.setTitle(title);
            a.setText(text);
            a.setAuthor(new Author(authorId));
            articleRepository.save(a);
        });

        return article;
    }

    public boolean deleteArticle(Long id) {
        articleRepository.deleteById(id);
        return true;
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Optional<Author> updateAuthor(Long id, String firstName, String lastName) {
        Optional<Author> author = authorRepository.findById(id);

        author.ifPresent(a -> {
            a.setFirstName(firstName);
            a.setLastName(lastName);
            authorRepository.save(a);
        });

        return author;
    }

    public boolean deleteAuthor(Long id) {
        authorRepository.deleteById(id);
        return true;
    }
}
