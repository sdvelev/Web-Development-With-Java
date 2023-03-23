package bg.fmi.course.wdwj;

import bg.fmi.course.wdwj.model.Book;
import bg.fmi.course.wdwj.repository.BookRepository;
import bg.fmi.course.wdwj.repository.BookRepositoryImpl;
import bg.fmi.course.wdwj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class WdwjApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(WdwjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("<<<<<<<<<<");

		Book book = new Book();
		book.setAuthor("ASD");
		book.setIsbn("123");
		book.setPrice(new BigDecimal(19.90));
		book.setPublishedYear(LocalDate.of(2023, 2, 2));

		bookService.add(book);

		List<Book> booksByAuthor = bookService.getAllBooksByAuthor("ASD");
		System.out.println(booksByAuthor);

		List<Book> booksAfterYear = bookService.getAllBooksPublishedAfter(LocalDate.of(2022, 2, 2));
		System.out.println(booksAfterYear);

		bookService.clear();
		System.out.println(bookService.getAllBooksGroupByAuthor());
	}
}
