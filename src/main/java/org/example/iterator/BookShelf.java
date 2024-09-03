package org.example.iterator;

import java.util.Iterator;

// 処理を繰り返す対象を表すIF
// その実装クラスなので、「何かが沢山集まっているもの」を表現している
// なのでBookが集まっているクラスとなる(=本棚)
public class BookShelf implements Iterable<Book> {
    private Book[] books;
    private int last = 0;

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }

    // 大事なのはここで、Iterator IFを返さないといけない
    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}
