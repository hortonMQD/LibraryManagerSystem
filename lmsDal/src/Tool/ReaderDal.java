package Tool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

import pojo.ReaderInfo;

public class ReaderDal extends DBTool{
	
	/**
	 * 删除读者信息
	 * @param ID	读者ID
	 * @return		若成功返回大于0的数
	 */
	public int Delete(String readerID) {
		int result = 0;
		String sql = "delete from reader where ID = ?;";
		String[] messages = {readerID};
		result = InsertUpdateDelete(sql, messages);
		return result;
	}
	
	
	/**
	 * 修改读者信息
	 * @param reader	读者信息
	 * @return		若成功返回大于0的数
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
	 * 添加读者信息
	 * @param reader	读者信息
	 * @return		若成功返回大于0的数
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
	 * 搜索所有读者详细信息
	 * @return	返回读者详细信息集合
	 */
	public List<ReaderInfo> SelectAllReader(){
		String sql = "SELECT ID,readerID,NAME,sex,birthday,createDate,telephone,address,money,maxNum,nowNum,TIMESTAMPDIFF(YEAR,reader.`birthday`,NOW()) FROM reader";
		return setReaderData(SelectNoParameter(sql));
	}
	
	
	
	/**
	 * 根据读者相关信息查询读者详细信息
	 * @param message	读者相关信息
	 * @param selectType	传入的读者信息搜索类型
	 * @return	返回读者详细信息集合
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
	 * 将数据集合的数据转换成json字符串
	 * @param readers	读者集合
	 * @return	json字符串
	 */
	public String setReaderDataString(List<ReaderInfo> readers) {
		return JSON.toJSONString(readers);
	}
	
	
}
