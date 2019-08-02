package pojo;

public class TicketInfo {
	
	
	private String ticketID;			//罚单编号
	private String readerID;			//读者编号
	private String antipateReturn;		//预计归还日期
	private String returnDate;			//实际归还日期
	private String overTime;			//超出时间
	private String penal;				//罚款金额
	private String gathering;			//收款金额
	private String pay;					//收款人
	private String gatheringDate;		//收款日期
	
	
	public TicketInfo() {}


	public String getTicketID() {
		return ticketID;
	}


	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}


	public String getReaderID() {
		return readerID;
	}


	public void setReaderID(String readerID) {
		this.readerID = readerID;
	}


	public String getAntipateReturn() {
		return antipateReturn;
	}


	public void setAntipateReturn(String antipateReturn) {
		this.antipateReturn = antipateReturn;
	}


	public String getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}


	public String getOverTime() {
		return overTime;
	}


	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}


	public String getPenal() {
		return penal;
	}


	public void setPenal(String penal) {
		this.penal = penal;
	}


	public String getGathering() {
		return gathering;
	}


	public void setGathering(String gathering) {
		this.gathering = gathering;
	}


	public String getPay() {
		return pay;
	}


	public void setPay(String pay) {
		this.pay = pay;
	}


	public String getGatheringDate() {
		return gatheringDate;
	}


	public void setGatheringDate(String gatheringDate) {
		this.gatheringDate = gatheringDate;
	}
	
	

}
