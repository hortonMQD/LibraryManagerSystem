package pojo;

public class BorrowInfo {
	
	private String readerID;		//外键 读者编号
	private String bookID;			//外键 书籍ISBN编号
	private String bookName;		//书籍名称
	private String borrowDate;		//借出日期
	private String operationBorrow; //借出操作人
	private String returnDate;		//归还日期
	private String operationReturn;	//归还操作人
	private String antipateReturn;	//预计归还日期
	private String ticketID;		//外键 罚单编号
	
	public BorrowInfo() {}

	public String getReaderID() {
		return readerID;
	}

	public void setReaderID(String readerID) {
		this.readerID = readerID;
	}
	
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}

	public String getOperationBorrow() {
		return operationBorrow;
	}

	public void setOperationBorrow(String operationBorrow) {
		this.operationBorrow = operationBorrow;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getOperationReturn() {
		return operationReturn;
	}

	public void setOperationReturn(String operationReturn) {
		this.operationReturn = operationReturn;
	}

	public String getAntipateReturn() {
		return antipateReturn;
	}

	public void setAntipateReturn(String antipateReturn) {
		this.antipateReturn = antipateReturn;
	}

	public String getTicketID() {
		return ticketID;
	}

	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}
	
	
	

}
