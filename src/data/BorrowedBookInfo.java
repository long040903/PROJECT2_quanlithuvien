package data;

public class BorrowedBookInfo {
    private BookData book;
    private int quantity;

    public BorrowedBookInfo(BookData book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public BookData getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

