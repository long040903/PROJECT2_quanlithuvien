package data;

import java.time.LocalDate;

public class BorrowedBookDetailData {
	private int id;
    private int borrowId;
    private int bookId; 
    private LocalDate borrowDate; 
    private LocalDate dueDate;
    
	public BorrowedBookDetailData() {
		
	}

	public BorrowedBookDetailData(int id, int borrowId, int bookId, LocalDate borrowDate, LocalDate dueDate) {
		super();
		this.id = id;
		this.borrowId = borrowId;
		this.bookId = bookId;
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBorrowId() {
		return borrowId;
	}

	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
    
    
}
