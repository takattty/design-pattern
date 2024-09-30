package org.example.proxy.ex;

public class BookService {
    private final BookDatabase database;

    public BookService() {
        // ここでdatabaseがnullなのかどうかを判断して、あればキャッシュを返すでもいいかも
        this.database = new BookDatabase();
    }

    public Book getBookInfo(String isbn) {
        return database.findBook(isbn);
    }
}
