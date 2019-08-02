package pojo;

import com.mysql.cj.jdbc.Blob;

public class UserInfo {

	private String ID;			//用户表主键
	private String userID;		//用户编号
	private Blob image;			//头像
	private String name;		//姓名
	private String sex;			//性别
	private String birthday;	//出生日期
	private String telephone;	//联系电话
	private String address;		//家庭住址
	private String password;	//密码
	private String identity;	//身份(职员、馆长)
	private String leader;		//领导/上级
	private String salary;		//工资
	private String age;			//年龄
	
	public UserInfo() {
		ID = java.util.UUID.randomUUID().toString().substring(24);
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getIdentity() {
		return identity;
	}


	public void setIdentity(String identity) {
		this.identity = identity;
	}


	public String getLeader() {
		return leader;
	}


	public void setLeader(String leader) {
		this.leader = leader;
	}


	public String getSalary() {
		return salary;
	}


	public void setSalary(String salary) {
		this.salary = salary;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}
	
	
	
}
