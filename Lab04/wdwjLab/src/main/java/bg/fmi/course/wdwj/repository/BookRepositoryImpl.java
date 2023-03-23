package bg.fmi.course.wdwj.repository;

import bg.fmi.course.wdwj.model.Book;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private Map<String, Book> db = new ConcurrentHashMap<>(); // new HashMap<>();


    @Override
    public void add(Book book) {
        db.put(book.getIsbn(), book);
    }

    @Override
    public Book getByIsbn(String isbn) {
        return db.get(isbn);
    }

    @Override
    public List<Book> getBooks() {
        return db.values().stream().toList();
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        return getBooks().stream()
            .filter(book -> book.getAuthor().equals(author))
            .collect(Collectors.toList());
    }

    @Override
    public void remove(Book book) {
        db.remove(book.getIsbn());
    }

    @Override
    public List<Book> getAllBooksPublishedAfter(LocalDate from) {
        return getBooks().stream()
            .filter(book -> book.getPublishedYear().isAfter(from))
            .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksBetween(LocalDate from, LocalDate to) {
        return getBooks().stream()
            .filter(book -> book.getPublishedYear().isAfter(from) && book.getPublishedYear().isBefore(to))
            .collect(Collectors.toList());
    }

    @Override
    public void clear() {
        this.db.clear();
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByAuthor() {
        return getBooks().stream()
            .collect(Collectors.groupingBy(Book::getAuthor));
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByPublisher() {
        return getBooks().stream()
            .collect(Collectors.groupingBy(Book::getPublisher));
    }

    @Override
    public List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate) {
        return getBooks().stream()
            .filter(bookPredicate)
            .collect(Collectors.toList());
    }
}
