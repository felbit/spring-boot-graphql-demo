package de.sandstorm.springboot.graphqldemo;

import de.sandstorm.springboot.graphqldemo.repository.ArticleRepository;
import de.sandstorm.springboot.graphqldemo.resolver.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlDemoApplication.class, args);
	}

}
