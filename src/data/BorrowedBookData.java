package data;

import java.sql.Date;
import java.time.LocalDate;

public class BorrowedBookData {
	private int id;
    private int customerId;
    private int userId; 
    private LocalDate borrowDate; 
    private LocalDate dueDate;
    
	public BorrowedBookData() {
		
	}

	public BorrowedBookData(int id, int customerId, int userId, LocalDate borrowDate, LocalDate dueDate) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.userId = userId;
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
