package Bll;

import java.sql.SQLException;
import java.util.List;

import Tool.BorrowDal;
import pojo.BorrowInfo;

public class BorrowBll {

	private BorrowDal borrowDal = new BorrowDal();
	
	public boolean Borrow(String readerID,String ISBN,String userID) {
		boolean result = false;
		//readerID = new ReaderBll().SelectReader(readerID,"用户编号").get(0).getID();
		try {
			result = borrowDal.Borrow(readerID, ISBN, userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	public List<BorrowInfo> selectBorrow(String readerID){
		return borrowDal.selectBorrow(readerID);
	}
	
	
	
	
	
	
	public boolean Return(String readerID,String ISBN,String userID) {
		boolean result = false;
		//readerID = new ReaderBll().SelectReader(readerID,"用户编号").get(0).getID();
		try {
			result = borrowDal.Return(readerID, ISBN, userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
