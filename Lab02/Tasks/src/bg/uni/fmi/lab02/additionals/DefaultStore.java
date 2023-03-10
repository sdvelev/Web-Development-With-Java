package bg.uni.fmi.lab02.additionals;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DefaultStore implements Store {

    private final Set<Book> storeCollection;

    public DefaultStore() {
        this.storeCollection = new HashSet<>();
    }

    public DefaultStore(Set<Book> storeCollection) {
        this.storeCollection = storeCollection;
    }

    /**
     * Add book to the store
     *
     * @param o is the book which we want to add
     * @return true if the book is added successful and false if the book already exists
     */
    @Override
    public boolean add(Book o) {
        return this.storeCollection.add(o);
    }

    /**
     * Remove specific book from the store
     *
     * @param o is the book which we want to remove
     */
    @Override
    public void remove(Book o) {
        this.storeCollection.remove(o);
    }

    /**
     * Get all books by Author
     *
     * @param author
     * @return
     */
    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        return this.storeCollection.stream()
            .filter(book -> book.getAuthor().equals(author))
            .collect(Collectors.toList());
    }

    /**
     * Get all books publish after specific year
     *
     * @param from
     * @return
     */
    @Override
    public List<Book> getAllBooksPublishedAfter(LocalDate from) {
        return this.storeCollection.stream()
            .filter(book -> book.getPublishedYear().isAfter(from))
            .collect(Collectors.toList());
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
        return this.storeCollection.stream()
            .filter(book -> book.getPublishedYear().isBefore(to) && book.getPublishedYear().isAfter(from))
            .collect(Collectors.toList());
    }

    /**
     * Clear the whole book store
     */
    @Override
    public void clear() {
        this.storeCollection.clear();
    }

    /**
     * Return all books grouped by author
     *
     * @return
     */
    @Override
    public Map<String, List<Book>> getAllBooksGroupByAuthor() {
        return this.storeCollection.stream()
            .collect(Collectors.groupingBy(Book::getAuthor));
    }

    /**
     * Return all books grouped by publisher
     *
     * @return
     */
    @Override
    public Map<String, List<Book>> getAllBooksGroupByPublisher() {
        return this.storeCollection.stream()
            .collect(Collectors.groupingBy(Book::getPublisher));
    }

    /**
     * Filter books by given filter
     *
     * @param bookPredicate
     * @return
     */
    @Override
    public List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate) {
        return this.storeCollection.stream()
            .filter(bookPredicate)
            .collect(Collectors.toList());
    }
}
