package Bll;

import java.util.ArrayList;
import java.util.List;

import Tool.BookDal;
import pojo.BookInfo;

public class BookBll {

	private BookDal bookDal = new BookDal();
	
	public List<BookInfo> SelectAllBook(){
		return bookDal.SelectAllBook();
	}
	
	
	public List<BookInfo> SelectBook(String message,String selectType){
		List<BookInfo> books = new ArrayList<>();
		switch (selectType) {
		case "ISBN":books = bookDal.SelectBookWithParameter(message, "ISBN");
			break;
		case "书名":books = bookDal.SelectBookWithParameter(message, "name");
			break;
		case "馆藏位置":books = bookDal.SelectBookWithParameter(message, "location");
			break;
		case "出版社":books = bookDal.SelectBookWithParameter(message, "publishing");
			break;
		case "作者":books = bookDal.SelectBookWithParameter(message, "author");
			break;
		}
		return books;
	}
	
	
	public Boolean Delete(String ISBN) {
		return isTrue(bookDal.Delete(ISBN));
	}
	
	
	public Boolean Update(BookInfo book) {
		return isTrue(bookDal.Update(book));
	}
	
	
	public Boolean Insert(BookInfo book) {
		return isTrue(bookDal.Insert(book));
	}
	
	
	public Boolean isTrue(int result) {
		if (result > 0) {
			return true;
		}
		return false;
	}
	
	
	public int[] ChartData() {
		List<BookInfo> books = SelectAllBook();
		int SpaceScience = 0;
		int NaturalPhysical = 0;
		int ComputerScience = 0;
		int Humanity = 0;
		int Philosophy = 0;
		int PhysicalGeography = 0;
		int HistoricalDocument = 0;
		for(BookInfo book : books) {
			switch (book.getType()) {
			case "宇宙科学类": SpaceScience++;
				break;
			case "自然物理类": NaturalPhysical++;
				break;
			case "计算机科学类": ComputerScience++;
				break;
			case "人文类": Humanity++;
				break;
			case "哲学类": Philosophy++;
				break;
			case "自然地理类": PhysicalGeography++;
				break;
			case "历史文献": HistoricalDocument++;
				break;
			}
		}
		int[] data = {SpaceScience,NaturalPhysical,ComputerScience,Humanity,Philosophy,PhysicalGeography,HistoricalDocument};
		return data;
	}	
	
}
