package org.example.proxy.ex;

import java.util.HashMap;
import java.util.Map;

public class BookDatabase {
    private Map<String, Book> books = new HashMap<>();

    public BookDatabase() {
        // サンプルデータの追加
        books.put("978-4-1234-5678-9", new Book("978-4-1234-5678-9", "Java入門", 3000));
        books.put("978-4-9876-5432-1", new Book("978-4-9876-5432-1", "デザインパターン", 4500));
    }

    public Book findBook(String isbn) {
        // データベースアクセスを模倣するための遅延
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return books.get(isbn);
    }
}
