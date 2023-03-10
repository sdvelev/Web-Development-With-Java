package bg.uni.fmi.lab02.additionals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Book {

    private String title;
    private String author;
    private BigDecimal price;
    private String publisher;
    private LocalDate publishedYear;

    public Book(String title, String author, BigDecimal price, String publisher, LocalDate publishedYear) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
        this.publishedYear = publishedYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(LocalDate publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) && author.equals(book.author) && publishedYear.equals(book.publishedYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publishedYear);
    }
}
