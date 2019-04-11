package de.sandstorm.springboot.graphqldemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private String text;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Article(String title, String text, Author author) {
        this.title = title;
        this.text = text;
        this.author = author;
    }

}
