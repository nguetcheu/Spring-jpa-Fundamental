package com.aliboucoding.JPA;

import com.aliboucoding.JPA.models.Author;
import com.aliboucoding.JPA.models.AuthorSpecification;
import com.aliboucoding.JPA.repositories.AuthorRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}



	@Bean
	public CommandLineRunner commandLine(
		AuthorRepository repository
	) {
		return args -> {
			/*
			for (int i=0; i< 50; i++) {
				Faker faker = new Faker();
				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(19, 50))
						.email("contact" + i + "@gmail.com")
						.build();

				repository.save(author);
			}
		};
			 */
			/*
			Faker faker = new Faker();
			var author = Author.builder()
					.firstName(faker.name().firstName())
					.lastName(faker.name().lastName())
					.age(21)
					.email("dnguetcheu@gmail.com")
					.build();

			repository.save(author);

			repository.updateAuthor(32, 52);
			 */

			// repository.updateByNamedQuery(21);

			/*Specification<Author> spec = Specification
					.where(AuthorSpecification.hasAge(34))
					.and(AuthorSpecification.firstNameLike("Mi"));

			repository.findAll(spec).forEach(System.out::println);
			 */
		};

	}

}
