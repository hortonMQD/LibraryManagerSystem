package Tool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.BookInfo;

public class BookDal extends DBTool{
	
	
	/**
	 * 添加书籍信息
	 * @param book	书籍信息
	 * @return	若成功大于0则插入成功
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
	 * 修改书籍信息
	 * @param book	书籍信息
	 * @return	若成功大于0则修改成功
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
	 * 删除书籍信息
	 * @param ISBN	书籍ISBN编号
	 * @return	若成功大于0则删除成功
	 */
	public int Delete(String ISBN) {
		int result = 0;
		String sql = "delete from book where ISBN = ?;";
		String[] messages = {ISBN};
		result = InsertUpdateDelete(sql, messages);
		return result;
	}
	
	
	/**
	 * 查询所有书籍信息
	 * @return	返回书籍详细信息集合
	 */
	public List<BookInfo> SelectAllBook(){
		ResultSet res = SelectNoParameter("select * from book");
		return setBookData(res);
	}
	
	/**
	 * 根据传入的书籍信息查找书籍详细信息
	 * @param message	书籍相关信息
	 * @param SelectType	传入的书籍信息类型
	 * @return	返回书籍详细信息队列
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
	 * 将数据集合中的信息添加到书籍对象集合中
	 * @param ResultSet		书籍数据集合
	 * @return	书籍对象集合
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
