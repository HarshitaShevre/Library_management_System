package Admin.Model;

public class Library {
   
	private  int bookId;
	private String bookName;
	private String bookTitle;
	private String bookType;
	private String bookAuthor;
	private int bookQuantity;
	private String issueDate;
	private String receiveDate;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public int getBookQuantity() {
		return bookQuantity;
	}
	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}
	public Library(int bookId, String bookName, String bookTitle, String bookType, String bookAuthor, int bookQuantity,
			String issueDate, String receiveDate) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookTitle = bookTitle;
		this.bookType = bookType;
		this.bookAuthor = bookAuthor;
		this.bookQuantity = bookQuantity;
		this.issueDate = issueDate;
		this.receiveDate = receiveDate;
		
	}
	
	public Library(int bookId, String bookName, String bookTitle, String bookType, String bookAuthor,
			int bookQuantity) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookTitle = bookTitle;
		this.bookType = bookType;
		this.bookAuthor = bookAuthor;
		this.bookQuantity = bookQuantity;
	}
	
	public Library() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Library [bookId=" + bookId + ", bookName=" + bookName + ", bookTitle=" + bookTitle + ", bookType="
				+ bookType + ", bookAuthor=" + bookAuthor + ", bookQuantity=" + bookQuantity + ", issueDate="
				+ issueDate + ", receiveDate=" + receiveDate + "]";
	}	
}
