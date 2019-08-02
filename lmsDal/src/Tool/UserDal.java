package Tool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

import pojo.UserInfo;

public class UserDal extends DBTool{

	/**
	 * ɾ���û���Ϣ
	 * @param ID	�û�ID
	 * @return	���ɹ����ش���0����
	 */
	public int Delete(String ID) {
		int result = 0;
		String sql = "delete from user where ID = ?;";
		String[] messages = {ID};
		result = InsertUpdateDelete(sql, messages);
		return result;
	}
	
	/**
	 * �޸��û���Ϣ
	 * @param user	������û���Ϣ
	 * @return	���ɹ����ش���0����
	 */
	public int Update(UserInfo user) {
		int result = 0;
		String sql = "update user set name = ?,birthday = ?,telephone = ?,address = ?,identity = ?,salary = ?,leader = ? where ID = ?;";
		String[] messages = {user.getName(),user.getBirthday(),user.getTelephone(),user.getAddress(),user.getIdentity(),user.getSalary(),user.getLeader(),user.getID()};
		result = InsertUpdateDelete(sql, messages);
		return result;
	}
	
	
	/**
	 * �޸��û�����
	 * @param user	������û���Ϣ
	 * @return	���ɹ����ش���0����
	 */
	public int UpdatePassword(UserInfo user) {
		int result = 0;
		String sql = "update user set password = ? where ID = ?;";
		String[] messages = {user.getPassword(),user.getID()};
		result = InsertUpdateDelete(sql, messages);
		return result;
	}
	
	
	/**
	 * ����û���Ϣ
	 * @param user	������û���Ϣ
	 * @return	���ɹ����ش���0����
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
	 * �����û�ID
	 * @return	�����û�ID����
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
	 * ���������û���Ϣ
	 * @return	�����û���Ϣ����
	 */
	public List<UserInfo> SelectAllUser(){
		String sql = "select ID,userID,image,name,birthday,telephone,address,identity,salary,leader,password,TIMESTAMPDIFF(YEAR,user.`birthday`,now()) from user;";
		return setUserData(SelectNoParameter(sql));
	}
	
	
	/**
	 * ���ݴ�����û��������Ϣ�����û���ϸ��Ϣ
	 * @param message	�û������Ϣ
	 * @param SelectType	������û���Ϣ��������
	 * @return	�����û���Ϣ����
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
	 * �����ݼ��ϵ�����ת����json�ַ���
	 * @param users	�û�����
	 * @return	json�ַ���
	 */
	public String getUserDataString(List<UserInfo> users) {
		return JSON.toJSONString(users);
	}
	
	
	
	
	
	
}
