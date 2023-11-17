package com.ismail.bookstore;

import com.ismail.bookstore.model.Book;
import com.ismail.bookstore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {

	private final BookRepository bookRepository ;

	public BookStoreApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Book book1 = Book.builder()
				.name("Yuzuklerin efendisi")
				.author("Ahmet Kaya")
				.price(10.0)
				.stock(10).build();
		Book book2 = Book.builder()
				.name("One Piece")
				.author("Eichiro Oda")
				.price(31.0)
				.stock(11).build();
		Book book3 = Book.builder()
				.name("Mehmetlerin efendisi")
				.author("Mehmet Kaya")
				.price(15.0)
				.stock(10).build();
		bookRepository.saveAll(Arrays.asList(book1, book2, book3));
	}

}
