package org.example.proxy.ex;

public class BookService {
    private final BookDatabase database;

    public BookService() {
        this.database = new BookDatabase();
    }

    public Book getBookInfo(String isbn) {
        return database.findBook(isbn);
    }
}
