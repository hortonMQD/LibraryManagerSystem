package Tool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

import pojo.ReaderInfo;

public class ReaderDal extends DBTool{
	
	/**
	 * ɾ��������Ϣ
	 * @param ID	����ID
	 * @return		���ɹ����ش���0����
	 */
	public int Delete(String readerID) {
		int result = 0;
		String sql = "delete from reader where ID = ?;";
		String[] messages = {readerID};
		result = InsertUpdateDelete(sql, messages);
		return result;
	}
	
	
	/**
	 * �޸Ķ�����Ϣ
	 * @param reader	������Ϣ
	 * @return		���ɹ����ش���0����
	 */
	public int Update(ReaderInfo reader) {
		int result = 0;
		String sql = "update reader set name = ?,sex = ?,birthday = ?,createDate = ?,telephone = ?,address = ?,money = ?,maxNum = ?,nowNum = ? where ID = ?;";
		String[] messages = {reader.getName(),reader.getSex(),reader.getBirthday(),reader.getCreateDate(),reader.getTelephone(),reader.getAddress(),
				reader.getMoney(),reader.getMaxNum(),reader.getNowNum(),reader.getID()};
		result = InsertUpdateDelete(sql, messages);
		return result;
	}
	
	
	/**
	 * ��Ӷ�����Ϣ
	 * @param reader	������Ϣ
	 * @return		���ɹ����ش���0����
	 */
	public int Insert(ReaderInfo reader) {
		int result = 0;
		String sql = "insert reader(ID,readerID,name,sex,birthday,createDate,telephone,address,money,maxNum,nowNum) "
				+ " values(?,?,?,?,?,now(),?,?,?,?,?);";
		String[] messages = {reader.getID(),reader.getReaderID(),reader.getName(),reader.getSex(),reader.getBirthday(),reader.getTelephone(),
				reader.getAddress(),reader.getMoney(),reader.getMaxNum(),reader.getNowNum()};
		result = InsertUpdateDelete(sql, messages);
		return result;
	}
	
	
	
	/**
	 * �������ж�����ϸ��Ϣ
	 * @return	���ض�����ϸ��Ϣ����
	 */
	public List<ReaderInfo> SelectAllReader(){
		String sql = "SELECT ID,readerID,NAME,sex,birthday,createDate,telephone,address,money,maxNum,nowNum,TIMESTAMPDIFF(YEAR,reader.`birthday`,NOW()) FROM reader";
		return setReaderData(SelectNoParameter(sql));
	}
	
	
	
	/**
	 * ���ݶ��������Ϣ��ѯ������ϸ��Ϣ
	 * @param message	���������Ϣ
	 * @param selectType	����Ķ�����Ϣ��������
	 * @return	���ض�����ϸ��Ϣ����
	 */
	public List<ReaderInfo> SelectReaderWithParameter(String message,String selectType){
		String sql = "select ID,readerID,name,sex,birthday,createDate,telephone,address,money,maxNum,nowNum,TIMESTAMPDIFF(YEAR,reader.`birthday`,now()) from reader where "+ selectType+ "  = ?;";
		String[] messages = {message};
		return setReaderData(SelectWithParameter(sql, messages));
	}

	public List<ReaderInfo> setReaderData(ResultSet res){
		List<ReaderInfo> readers = new ArrayList<>();
		try {
			while(res.next()) {
				ReaderInfo reader = new ReaderInfo();
				reader.setID(res.getString(1));
				reader.setReaderID(res.getString(2));
				reader.setName(res.getString(3));
				reader.setSex(res.getString(4));
				reader.setBirthday(res.getString(5));
				reader.setCreateDate(res.getString(6));
				reader.setTelephone(res.getString(7));
				reader.setAddress(res.getString(8));
				reader.setMoney(res.getString(9));
				reader.setMaxNum(res.getString(10));
				reader.setNowNum(res.getString(11));
				reader.setAge(res.getString(12));
				readers.add(reader);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return readers;
	}
	
	
	
	/**
	 * �����ݼ��ϵ�����ת����json�ַ���
	 * @param readers	���߼���
	 * @return	json�ַ���
	 */
	public String setReaderDataString(List<ReaderInfo> readers) {
		return JSON.toJSONString(readers);
	}
	
	
}
