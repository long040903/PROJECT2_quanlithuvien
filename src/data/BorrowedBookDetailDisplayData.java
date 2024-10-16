package data;

public class BorrowedBookDetailDisplayData {
    private String borrowDate;
    private String dueDate;
    private String bookName;
    private int quantity;

    public BorrowedBookDetailDisplayData(String borrowDate, String dueDate, String bookName, int quantity) {
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.bookName = bookName;
        this.quantity = quantity;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

