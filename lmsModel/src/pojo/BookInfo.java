package pojo;

public class BookInfo {

	private String ISBN;		//�鼮ISBN���
	private String name;		//����
	private StringBuilder text;		//�鼮���
	private String author;		//�鼮����
	private String type;		//�鼮����
	private String publishing;	//������
	private String createDate;	//��������
	private String location;	//�ݲ�λ��
	private String state;		//�ݲ�λ��
	private String principal;	//�����
	private String addDate;		//���ʱ��
	private String pageCount;	//�鼮ҳ��
	private String price;		//�鼮�۸�
	
	
	
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
