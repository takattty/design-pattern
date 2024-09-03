package org.example.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

// 処理を繰り返す反復子を表すIF
public class BookShelfIterator implements Iterator<Book> {
    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    // 次の本があるかを調べる
    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength();
    }

    // 今指定している本を取り出すのと当時に次の指定を進める
    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
