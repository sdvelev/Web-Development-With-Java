package bg.fmi.course.wdwj.repository;

import bg.fmi.course.wdwj.model.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public interface BookRepository {

    void add(Book book);
    Book getByIsbn(String isbn);

    List<Book> getBooks();

    List<Book> getAllBooksByAuthor(String author);

    void remove(Book book);
    List<Book> getAllBooksPublishedAfter(LocalDate from);
    List<Book> getAllBooksBetween(LocalDate from, LocalDate to);
    void clear();

    Map<String, List<Book>> getAllBooksGroupByAuthor();
    Map<String, List<Book>> getAllBooksGroupByPublisher();
    List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate);

}
