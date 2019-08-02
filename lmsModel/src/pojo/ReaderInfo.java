package pojo;

import com.mysql.cj.jdbc.Blob;

public class ReaderInfo {
	
	private String ID;			//���߱�����
	private String readerID;	//���߱��
	private Blob image;			//ͷ��
	private String name;		//����
	private String sex;			//�Ա�
	private String birthday;	//��������
	private String createDate;	//�쿨����
	private String telephone;	//��ϵ�绰
	private String address;		//��ͥסַ
	private String money;		//Ѻ��
	private String maxNum;			//���ɽ����
	private String nowNum;			//�ѽ����
	private String age;			//����
	
	
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
