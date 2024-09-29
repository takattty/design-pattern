package org.example.proxy.ex;

public class OnlineBookstore {
    public static void main(String[] args) {
        BookService service = new BookService();

        // 書籍情報の取得
        String isbn = "978-4-1234-5678-9";
        Book book = service.getBookInfo(isbn);

        if (book != null) {
            System.out.println("書籍情報:");
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("タイトル: " + book.getTitle());
            System.out.println("価格: " + book.getPrice() + "円");
        } else {
            System.out.println("書籍が見つかりません。");
        }
    }
}
