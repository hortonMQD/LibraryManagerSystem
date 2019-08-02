package Tool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.BorrowInfo;

public class BorrowDal extends DBTool{
	
	
	
	
	
	public boolean Borrow(String readerID,String ISBN,String userID) throws SQLException {
		
		Connection connection = ConnectSQL();
		
			try {
				connection.setAutoCommit(false);		//关闭自动提交，开启事务
				Statement stmt = connection.createStatement();
				{
				stmt.executeUpdate("UPDATE reader SET nowNum = nowNum+1 where ID = '"+readerID+"'");
				stmt.executeUpdate("insert borrow(readerID,bookID,borrowDate,operationBorrow,antipateReturn) "
						              + "values('"+readerID+"','"+ISBN+"',NOW(),'"+userID+"',(SELECT DATE_ADD(NOW(),INTERVAL 1 MONTH)))");
				}
				connection.commit();
				connection.setAutoCommit(true);
				return true;
			}catch (SQLException e) {
				connection.rollback();
				e.printStackTrace();
				return false;
			}
	}
	
	
	
	
	public boolean Return(String readerID,String ISBN,String userID) throws SQLException {
		Connection connection = ConnectSQL();
		
		try {
			connection.setAutoCommit(false);		//关闭自动提交，开启事务
			Statement stmt = connection.createStatement();
			{
			stmt.executeUpdate("UPDATE reader SET nowNum = nowNum-1 where ID = '"+readerID+"'");
			stmt.executeUpdate("UPDATE borrow SET operationReturn = '"+userID+"',retutnDate = (CASE WHEN retutnDate IS NULL THEN NOW() ELSE retutnDate END) "
					+ "WHERE readerID = '"+readerID+"' AND bookID = '"+ISBN+"';");
			}
			connection.commit();
			connection.setAutoCommit(true);
			return true;
		}catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	
	public List<BorrowInfo> selectBorrow(String ReaderID){
		String sql = "select borrow.readerID,borrow.bookID,borrow.borrowDate,borrow.operationBorrow,"
				+ " borrow.retutnDate,borrow.operationReturn,borrow.antipateReturn,borrow.ticketID,book.name from borrow,book where borrow.readerID = ?  AND borrow.`bookID` = book.`ISBN`";
		String[] message = {ReaderID};
		ResultSet res = SelectWithParameter(sql, message);
		List<BorrowInfo> borrowInfos = initBorrow(res);
		return borrowInfos;
	}
	
	
	
	private List<BorrowInfo> initBorrow(ResultSet res) {
		List<BorrowInfo> borrowInfos = new ArrayList<BorrowInfo>();
		try {
			while (res.next()) {
				BorrowInfo borrowInfo = new BorrowInfo();
				borrowInfo.setReaderID(res.getString(1));
				borrowInfo.setBookID(res.getString(2));
				borrowInfo.setBorrowDate(res.getString(3));
				borrowInfo.setOperationBorrow(res.getString(4));
				borrowInfo.setReturnDate(res.getString(5));
				borrowInfo.setOperationReturn(res.getString(6));
				borrowInfo.setAntipateReturn(res.getString(7));
				borrowInfo.setTicketID(res.getString(8));
				borrowInfo.setBookName(res.getString(9));
				borrowInfos.add(borrowInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return borrowInfos;
	}
	
	
	
	
	
	
	
	
	/**
	 * 添加借书记录
	 * @param readerID	读者编号
	 * @param ISBN		书籍ISBN编号
	 * @param userID	用户ID
	 * @return	若成功返回大于0的数
	 */
	public int BorrowTest(String readerID,String ISBN,String userID) {
		int result = 0;
		String sql = "insert borrow(readerID,bookID,borrowDate,operationBorrow,antipateReturn) values((select ID from reader where readerID = ?),?,NOW(),"
				+ "(select ID from user where userID = ?),(SELECT DATE_ADD(NOW(),INTERVAL 1 MONTH)))";
		String[] messages = {readerID,ISBN,userID};
		result = InsertUpdateDelete(sql, messages);
		return result;
	}
	
	
	
	
	
	
	/**
	 * 修改借书记录
	 * @param readerID	读者编号
	 * @param ISBN		书籍ISBN编号
	 * @param userID	用户ID
	 * @return	若成功返回大于0的数
	 */
	public int ReturnTest(String readerID,String ISBN,String userID) {
		int result = 0;
		String sql = "update borrow set retutnDate = NOW(),operationReturn = ? where (select ID from where readerID = ?) and bookID = ?;";
		String[] messages = {userID,readerID,ISBN};
		result = InsertUpdateDelete(sql, messages);
		return result;
	}
	
	
}
