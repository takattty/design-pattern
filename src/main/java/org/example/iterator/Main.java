package org.example.iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));

        // 明示的にIteratorを使う方法
        Iterator<Book> it = bookShelf.iterator();
        // ここがBookShelf（Iterable）の実装に依存していないことが大事
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book.name());
        }
        System.out.println();

        // 拡張for文を使う方法
        // ここで拡張forを使えるのは、Iterable型
        for (Book book: bookShelf) {
            System.out.println(book.name());
        }
        System.out.println();
    }
}
