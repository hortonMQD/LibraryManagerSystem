package pojo;

import com.mysql.cj.jdbc.Blob;

public class ReaderInfo {
	
	private String ID;			//读者表主键
	private String readerID;	//读者编号
	private Blob image;			//头像
	private String name;		//姓名
	private String sex;			//性别
	private String birthday;	//出生日期
	private String createDate;	//办卡日期
	private String telephone;	//联系电话
	private String address;		//家庭住址
	private String money;		//押金
	private String maxNum;			//最大可借册数
	private String nowNum;			//已借册数
	private String age;			//年龄
	
	
	public ReaderInfo() {
		ID = java.util.UUID.randomUUID().toString().substring(24);
	}


	public String getID() {
		return ID;
	}


	
	public void setID(String iD) {
		ID = iD;
	}


	public String getReaderID() {
		return readerID;
	}


	public void setReaderID(String readerID) {
		this.readerID = readerID;
	}


	public Blob getImage() {
		return image;
	}


	public void setImage(Blob image) {
		this.image = image;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getMoney() {
		return money;
	}


	public void setMoney(String money) {
		this.money = money;
	}


	public String getMaxNum() {
		return maxNum;
	}


	public void setMaxNum(String maxNum) {
		this.maxNum = maxNum;
	}


	public String getNowNum() {
		return nowNum;
	}


	public void setNowNum(String nowNum) {
		this.nowNum = nowNum;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}
	
	
	
	
	

}
