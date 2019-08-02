package pojo;

public class BookInfo {

	private String ISBN;		//书籍ISBN编号
	private String name;		//书名
	private StringBuilder text;		//书籍简介
	private String author;		//书籍作者
	private String type;		//书籍类型
	private String publishing;	//出版社
	private String createDate;	//出版日期
	private String location;	//馆藏位置
	private String state;		//馆藏位置
	private String principal;	//添加人
	private String addDate;		//添加时间
	private String pageCount;	//书籍页数
	private String price;		//书籍价格
	
	
	
	public BookInfo() {
		
	}



	public String getISBN() {
		return ISBN;
	}



	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public StringBuilder getText() {
		return text;
	}



	public void setText(StringBuilder text) {
		this.text = text;
	}



	public String getPublishing() {
		return publishing;
	}



	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}



	public String getCreateDate() {
		return createDate;
	}



	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getPrincipal() {
		return principal;
	}



	public void setPrincipal(String principal) {
		this.principal = principal;
	}



	public String getAddDate() {
		return addDate;
	}



	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}



	public String getPageCount() {
		return pageCount;
	}



	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}
	
	
}
