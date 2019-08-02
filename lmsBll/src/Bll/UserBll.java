package Bll;

import java.util.ArrayList;
import java.util.List;

import Tool.UserDal;
import pojo.UserInfo;

public class UserBll {
	
	/**
	 * ��ѯ�����û���Ϣ
	 * @return	�����û���Ϣ����
	 */
	public List<UserInfo> SelectAllUser(){
		return new UserDal().SelectAllUser();
	}
	
	
	/**
	 * ���ݴ������Ϣ��ѯ�û���ϸ��Ϣ
	 * @param message	�û������Ϣ
	 * @param selectType	�û���Ϣ����
	 * @return		�����û���Ϣ����
	 */
	public List<UserInfo> SelectUser(String message,String selectType){
		List<UserInfo> users = null;
		switch (selectType) {
		case "����":		users = new UserDal().SelectUserWithParameter(message, "name");
			break;
		case "���":		users = new UserDal().SelectUserWithParameter(message, "userID");
			break;
		}
		return users;
	}
	
	
	/**
	 * �����û������û����������жϵ�½�Ƿ�ɹ�
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
	 * ����û���Ϣ
	 * @param user	�û���Ϣ����
	 * @return	���ɹ�����true
	 */
	public boolean Insert(UserInfo user) {
		return isTrue(new UserDal().Insert(user));
	}
	
	
	/**
	 * �޸��û���Ϣ
	 * @param user	�û���Ϣ����
	 * @return	���ɹ�����true
	 */
	public boolean Update(UserInfo user) {
		user.setLeader(new UserDal().SelectUserID(user.getLeader(),"name").get(0).getID());
		return isTrue(new UserDal().Update(user));
	}
	
	
	/**
	 * �޸��û�����
	 * @param user	�û���Ϣ����
	 * @return	���ɹ�����true
	 */
	public boolean UpdatePassword(UserInfo user) {
		return isTrue(new UserDal().UpdatePassword(user));
	}
	
	
	
	/**
	 * ɾ���û���Ϣ
	 * @param UserID	�û�ID
	 * @return	���ɹ�����true
	 */
	public boolean Delete(String UserID) {
		String ID = new UserDal().SelectUserID(UserID, "userID").get(0).getID();
		return isTrue(new UserDal().Delete(ID));
	}
	
	
	/**
	 * �жϲ����Ƿ�ɹ����������������0��������ɹ�
	 * @param result	�������ص���
	 * @return	�������������0���򷵻�true
	 */
	public boolean isTrue(int result) {
		if (result > 0) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * ��������˵�����
	 * @return	������������
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
	 * ����ͼ�����ݣ�Ա������ֶΣ�
	 * @return	����������������
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
	 * ����ͼ�����ݣ�Ա�����ʷֶΣ�
	 * @return	���ع��ʷֶ���������
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
