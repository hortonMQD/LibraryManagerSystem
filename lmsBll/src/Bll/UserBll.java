package Bll;

import java.util.ArrayList;
import java.util.List;

import Tool.UserDal;
import pojo.UserInfo;

public class UserBll {
	
	/**
	 * 查询所有用户信息
	 * @return	返回用户信息集合
	 */
	public List<UserInfo> SelectAllUser(){
		return new UserDal().SelectAllUser();
	}
	
	
	/**
	 * 根据传入的信息查询用户详细信息
	 * @param message	用户相关信息
	 * @param selectType	用户信息类型
	 * @return		返回用户信息集合
	 */
	public List<UserInfo> SelectUser(String message,String selectType){
		List<UserInfo> users = null;
		switch (selectType) {
		case "姓名":		users = new UserDal().SelectUserWithParameter(message, "name");
			break;
		case "编号":		users = new UserDal().SelectUserWithParameter(message, "userID");
			break;
		}
		return users;
	}
	
	
	/**
	 * 根据用户输入用户名、密码判断登陆是否成功
	 * @param userID
	 * @param PWD
	 * @param identity
	 * @return
	 */
	public Object Login(String userID,String PWD,String identity) {
		boolean result = false;
		List<UserInfo> users = new UserDal().SelectUserWithParameter(userID, "UserID");
		if (users.size()>0) {
			UserInfo user = users.get(0);
			if (user.getPassword().equals(PWD) && user.getIdentity().equals(identity)) {
				return user.getID();
			}
		}
		return result;
	}
	
	
	
	
	/**
	 * 添加用户信息
	 * @param user	用户信息对象
	 * @return	若成功返回true
	 */
	public boolean Insert(UserInfo user) {
		return isTrue(new UserDal().Insert(user));
	}
	
	
	/**
	 * 修改用户信息
	 * @param user	用户信息对象
	 * @return	若成功返回true
	 */
	public boolean Update(UserInfo user) {
		user.setLeader(new UserDal().SelectUserID(user.getLeader(),"name").get(0).getID());
		return isTrue(new UserDal().Update(user));
	}
	
	
	/**
	 * 修改用户密码
	 * @param user	用户信息对象
	 * @return	若成功返回true
	 */
	public boolean UpdatePassword(UserInfo user) {
		return isTrue(new UserDal().UpdatePassword(user));
	}
	
	
	
	/**
	 * 删除用户信息
	 * @param UserID	用户ID
	 * @return	若成功返回true
	 */
	public boolean Delete(String UserID) {
		String ID = new UserDal().SelectUserID(UserID, "userID").get(0).getID();
		return isTrue(new UserDal().Delete(ID));
	}
	
	
	/**
	 * 判断操作是否成功，若传入的数大于0，则操作成功
	 * @param result	操作返回的数
	 * @return	若传入的数大于0，则返回true
	 */
	public boolean isTrue(int result) {
		if (result > 0) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * 获得所有人的姓名
	 * @return	返回姓名集合
	 */
	public List<String> getNameData(){
		List<UserInfo> users = SelectAllUser();
		List<String> Leaders = new ArrayList<>();
		for(UserInfo user : users) {
			Leaders.add(user.getName());
		}
		return Leaders;
	}
	
	
	
	
	
	
	
	/**
	 * 设置图表数据（员工年龄分段）
	 * @return	返回年龄人数数组
	 */
	public int[] setAgeChartData() {
		int[] data = null;
		int data20_30 = 0;
		int data30_40 = 0;
		int data40_50 = 0;
		int data50_60 = 0;
		int data60_70 = 0;
		List<UserInfo> users = SelectAllUser();
		for(UserInfo user : users) {
			int age = Integer.parseInt(user.getAge());
			if(age > 60) {
				data60_70++;
			}else if (age > 50) {
				data50_60++;
			}else if (age > 40) {
				data40_50++;
			}else if (age > 30) {
				data30_40++;
			}else if (age > 20) {
				data20_30++;
			}
		}
		data = new int[]{data20_30,data30_40,data40_50,data50_60,data60_70};
		return data;
	}
	
	
	/**
	 * 设置图表数据（员工工资分段）
	 * @return	返回工资分段人数数组
	 */
	public int[] setSalaryChartData() {
		int[] data = null;
		int data1000_2000 = 0;
		int data2000_3000 = 0;
		int data3000_4000 = 0;
		int data4000_5000 = 0;
		int data5000_6000 = 0;
		int data6000_7000 = 0;
		int data7000_10000 = 0;
		List<UserInfo> users = SelectAllUser();
		for(UserInfo user : users) {
			int salary = Integer.parseInt(user.getSalary());
			if(salary > 7000) {
				data7000_10000++;
			}else if (salary > 6000) {
				data6000_7000++;
			}else if (salary > 5000) {
				data5000_6000++;
			}else if (salary > 4000) {
				data4000_5000++;
			}else if (salary > 3000) {
				data3000_4000++;
			}else if (salary > 2000) {
				data2000_3000++;
			}else if (salary > 1000) {
				data1000_2000++;
			}
		}
		data = new int[]{data1000_2000,data2000_3000,data3000_4000,data4000_5000,data5000_6000,data6000_7000,data7000_10000};
		return data;
	}

}
