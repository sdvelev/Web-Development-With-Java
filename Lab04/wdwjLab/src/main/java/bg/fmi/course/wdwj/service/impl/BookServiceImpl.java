package bg.fmi.course.wdwj.service.impl;

import bg.fmi.course.wdwj.model.Book;
import bg.fmi.course.wdwj.repository.BookRepository;
import bg.fmi.course.wdwj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Add book to the store
     *
     * @param book is the book which we want to add
     * @return true is the book is add successful and false is the book is already exists
     */
    @Override
    public boolean add(Book book) {

        Book bookByIsbn = bookRepository.getByIsbn(book.getIsbn());
        if (bookByIsbn != null) {
            return false;
        }

        bookRepository.add(book);
        return true;
    }

    /**
     * Remove specific book from the store
     *
     * @param book is the book which we want to remove
     */
    @Override
    public void remove(Book book) {
        bookRepository.remove(book);
    }

    /**
     * Get all books by Author
     *
     * @param author
     * @return
     */
    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        if (author == null || author.isBlank()) {
            return new ArrayList<>();
        }

        return bookRepository.getAllBooksByAuthor(author);
    }

    /**
     * Get all books publish after specific year
     *
     * @param from
     * @return
     */
    @Override
    public List<Book> getAllBooksPublishedAfter(LocalDate from) {
        return bookRepository.getAllBooksPublishedAfter(from);
    }

    /**
     * Return all books between two dates
     *
     * @param from
     * @param to
     * @return
     */
    @Override
    public List<Book> getAllBooksBetween(LocalDate from, LocalDate to) {
        return bookRepository.getAllBooksBetween(from, to);
    }

    /**
     * Clear the whole book store
     */
    @Override
    public void clear() {
        bookRepository.clear();
    }

    /**
     * Return all books grouped by author
     *
     * @return
     */
    @Override
    public Map<String, List<Book>> getAllBooksGroupByAuthor() {
        return bookRepository.getAllBooksGroupByAuthor();
    }

    /**
     * Return all books grouped by publisher
     *
     * @return
     */
    @Override
    public Map<String, List<Book>> getAllBooksGroupByPublisher() {
        return bookRepository.getAllBooksGroupByPublisher();
    }

    /**
     * Filter books by given filter
     *
     * @param bookPredicate
     * @return
     */
    @Override
    public List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate) {
        return bookRepository.getAllBooksFilterBy(bookPredicate);
    }
}
