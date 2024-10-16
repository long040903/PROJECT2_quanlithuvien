package data;

public class BookData {
	private int bookID;
	private String bookName;
	private String authorName;
	private String publicationYear;
	private int quantity;
	private String bookImage;
	private int categoryId;
	private int areaID;
	private String categoryName;
    private String areaName;
    
	public BookData() {
		
	}

	public BookData(int bookID, String bookName, String authorName, String publicationYear, int quantity, String bookImage, int categoryId, int areaID, String categoryName, String areaName) {
		this.bookID = bookID;
		this.bookName = bookName;
		this.authorName = authorName;
		this.publicationYear = publicationYear;
		this.quantity = quantity;
		this.bookImage = bookImage;
		this.categoryId = categoryId;
		this.areaID = areaID;
		this.categoryName = categoryName;
		this.areaName = areaName;
	}
	
	public BookData(String bookName, String authorName, String publicationYear, int quantity, String bookImage, int categoryId, int areaID, String categoryName, String areaName) {
        // Gọi constructor hiện tại để khởi tạo bookID và các trường còn lại
        this(0, bookName, authorName, publicationYear, quantity, bookImage, categoryId, areaID, categoryName, areaName);
    }

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getAreaID() {
		return areaID;
	}

	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	} 
		
	
}
