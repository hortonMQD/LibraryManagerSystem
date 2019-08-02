package pojo;

public class BorrowInfo {
	
	private String readerID;		//��� ���߱��
	private String bookID;			//��� �鼮ISBN���
	private String bookName;		//�鼮����
	private String borrowDate;		//�������
	private String operationBorrow; //���������
	private String returnDate;		//�黹����
	private String operationReturn;	//�黹������
	private String antipateReturn;	//Ԥ�ƹ黹����
	private String ticketID;		//��� �������
	
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
