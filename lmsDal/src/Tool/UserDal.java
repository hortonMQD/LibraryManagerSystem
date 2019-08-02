package Tool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

import pojo.UserInfo;

public class UserDal extends DBTool{

	/**
	 * 删除用户信息
	 * @param ID	用户ID
	 * @return	若成功返回大于0的数
	 */
	public int Delete(String ID) {
		int result = 0;
		String sql = "delete from user where ID = ?;";
		String[] messages = {ID};
		result = InsertUpdateDelete(sql, messages);
		return result;
	}
	
	/**
	 * 修改用户信息
	 * @param user	传入的用户信息
	 * @return	若成功返回大于0的数
	 */
	public int Update(UserInfo user) {
		int result = 0;
		String sql = "update user set name = ?,birthday = ?,telephone = ?,address = ?,identity = ?,salary = ?,leader = ? where ID = ?;";
		String[] messages = {user.getName(),user.getBirthday(),user.getTelephone(),user.getAddress(),user.getIdentity(),user.getSalary(),user.getLeader(),user.getID()};
		result = InsertUpdateDelete(sql, messages);
		return result;
	}
	
	
	/**
	 * 修改用户密码
	 * @param user	传入的用户信息
	 * @return	若成功返回大于0的数
	 */
	public int UpdatePassword(UserInfo user) {
		int result = 0;
		String sql = "update user set password = ? where ID = ?;";
		String[] messages = {user.getPassword(),user.getID()};
		result = InsertUpdateDelete(sql, messages);
		return result;
	}
	
	
	/**
	 * 添加用户信息
	 * @param user	传入的用户信息
	 * @return	若成功返回大于0的数
	 */
	public int Insert(UserInfo user) {
		int result = 0;
		String sql = "insert user(ID,userID,name,birthday,telephone,address,identity,salary,leader,password) "
				+ " values(?,?,?,?,?,?,?,?,(select ID from user as a where name = ?),'123456');";
		String[] messages = {user.getID(),user.getUserID(),user.getName(),user.getBirthday(),user.getTelephone(),user.getAddress()
				,user.getIdentity(),user.getSalary(),user.getLeader()};
		result = InsertUpdateDelete(sql, messages);
		return result;
	}
	
	
	/**
	 * 搜索用户ID
	 * @return	返回用户ID集合
	 */
	public List<UserInfo> SelectUserID(String message,String type){
		String sql = "select ID from user where  "+type+"  = ?;";
		String[] parm = {message};
		ResultSet res = SelectWithParameter(sql,parm);
		List<UserInfo> users = new ArrayList<>();
		try {
			while (res.next()) {
				UserInfo user = new UserInfo();
				user.setID(res.getString(1));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	
	
	/**
	 * 搜索所有用户信息
	 * @return	返回用户信息集合
	 */
	public List<UserInfo> SelectAllUser(){
		String sql = "select ID,userID,image,name,birthday,telephone,address,identity,salary,leader,password,TIMESTAMPDIFF(YEAR,user.`birthday`,now()) from user;";
		return setUserData(SelectNoParameter(sql));
	}
	
	
	/**
	 * 根据传入的用户的相关信息查找用户详细信息
	 * @param message	用户相关信息
	 * @param SelectType	传入的用户信息搜索类型
	 * @return	返回用户信息集合
	 */
	public List<UserInfo> SelectUserWithParameter(String message,String SelectType){
		String sql = "select ID,userID,image,name,birthday,telephone,address,identity,salary,leader,password,TIMESTAMPDIFF(YEAR,user.`birthday`,now()) from user where "
				+SelectType+ " = ?;";
		String[] parm = {message};
		ResultSet res = SelectWithParameter(sql, parm);
		return setUserData(res);
	}
	
	
	private List<UserInfo> setUserData(ResultSet res){
		List<UserInfo> users = new ArrayList<>();
		try {
			while(res.next()) {
				UserInfo user = new UserInfo();
				user.setID(res.getString(1));
				user.setUserID(res.getString(2));
				user.setName(res.getString(4));
				user.setBirthday(res.getString(5));
				user.setTelephone(res.getString(6));
				user.setAddress(res.getString(7));
				user.setIdentity(res.getString(8));
				user.setSalary(res.getString(9));
				user.setLeader(res.getString(10));
				user.setPassword(res.getString(11));
				user.setAge(res.getString(12));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
	
	/**
	 * 将数据集合的数据转换成json字符串
	 * @param users	用户集合
	 * @return	json字符串
	 */
	public String getUserDataString(List<UserInfo> users) {
		return JSON.toJSONString(users);
	}
	
	
	
	
	
	
}
