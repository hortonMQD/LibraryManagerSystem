package Tool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.BookInfo;

public class BookDal extends DBTool{
	
	
	/**
	 * ����鼮��Ϣ
	 * @param book	�鼮��Ϣ
	 * @return	���ɹ�����0�����ɹ�
	 */
	public int Insert(BookInfo book) {
		int result = 0;
		String sql = "insert book(ISBN,name,author,text,publishing,createDate,pageCount,price,location,state,principal,addDate,type) values"
				+ "(?,?,?,?,?,?,?,?,?,?,?,NOW(),?)";
		String[] messages = {book.getISBN(),book.getName(),book.getAuthor(),book.getText().toString(),
				book.getPublishing(),book.getCreateDate(),book.getPageCount(),book.getPrice(),book.getLocation(),
				book.getState(),book.getPrincipal(),book.getType()};
		result = InsertUpdateDelete(sql, messages);
		return  result;
	}
	
	/**
	 * �޸��鼮��Ϣ
	 * @param book	�鼮��Ϣ
	 * @return	���ɹ�����0���޸ĳɹ�
	 */
	public int Update(BookInfo book) {
		int result = 0;
		String sql = "update book set name = ?,author = ?,text = ?,publishing = ?,createDate = ?,pageCount = ?,"
				+ "price = ?,location = ?,state = ?,principal = ?,addDate = ?, type = ? where ISBN = ?;";
		String[] messages = {book.getName(),book.getAuthor(),book.getText().toString(),book.getPublishing(),
				book.getCreateDate(),book.getPageCount(),book.getPrice(),book.getLocation(),
				book.getState(),book.getPrincipal(),book.getAddDate(),book.getType(),book.getISBN()};
		result = InsertUpdateDelete(sql, messages);
		return result;
	}
	
	
	/**
	 * ɾ���鼮��Ϣ
	 * @param ISBN	�鼮ISBN���
	 * @return	���ɹ�����0��ɾ���ɹ�
	 */
	public int Delete(String ISBN) {
		int result = 0;
		String sql = "delete from book where ISBN = ?;";
		String[] messages = {ISBN};
		result = InsertUpdateDelete(sql, messages);
		return result;
	}
	
	
	/**
	 * ��ѯ�����鼮��Ϣ
	 * @return	�����鼮��ϸ��Ϣ����
	 */
	public List<BookInfo> SelectAllBook(){
		ResultSet res = SelectNoParameter("select * from book");
		return setBookData(res);
	}
	
	/**
	 * ���ݴ�����鼮��Ϣ�����鼮��ϸ��Ϣ
	 * @param message	�鼮�����Ϣ
	 * @param SelectType	������鼮��Ϣ����
	 * @return	�����鼮��ϸ��Ϣ����
	 */
	public List<BookInfo> SelectBookWithParameter(String message,String SelectType) {
		List<BookInfo> books = null;
		String sql = "select * from book where " + SelectType + "  = ?;";
		String[] str = {message};
		ResultSet res = SelectWithParameter(sql,str);
		books = setBookData(res);
		return books;
	}

	
	
	
	/**
	 * �����ݼ����е���Ϣ��ӵ��鼮���󼯺���
	 * @param ResultSet		�鼮���ݼ���
	 * @return	�鼮���󼯺�
	 */
	public List<BookInfo> setBookData(ResultSet ResultSet) {
		List<BookInfo> books = new ArrayList<>();
		try {
			while(ResultSet.next()){
				BookInfo bookInfo = new BookInfo();
				bookInfo.setISBN(ResultSet.getString(1));
				bookInfo.setName(ResultSet.getString(3));
				bookInfo.setAuthor(ResultSet.getString(4));
				bookInfo.setText(new StringBuilder().append(ResultSet.getString(5)));
				bookInfo.setType(ResultSet.getString(6));
				bookInfo.setPublishing(ResultSet.getString(7));
				bookInfo.setCreateDate(ResultSet.getString(8));
				bookInfo.setPageCount(ResultSet.getString(9));
				bookInfo.setPrice(ResultSet.getString(10));
				bookInfo.setLocation(ResultSet.getString(11));
				bookInfo.setState(ResultSet.getString(12));
				bookInfo.setPrincipal(ResultSet.getString(13));
				bookInfo.setAddDate(ResultSet.getString(14));
				books.add(bookInfo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
	
	
}
