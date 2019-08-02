package Tool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.alibaba.fastjson.JSON;
import com.mysql.cj.jdbc.Driver;


public abstract class DBTool {
	
	static Connection con;
	static PreparedStatement sql;
	static ResultSet res;
	
	public DBTool() {
		
	}
	
	
	/**
	 * �������ݿ�����
	 */
    @SuppressWarnings("finally")
	public static Connection ConnectSQL() {   //�����������ݿ�ķ���   ����������ļ̳�
		try {
			Driver driver = new Driver();
			String url = "jdbc:mysql://localhost:3306/librarymanagersystem?serverTimezone=GMT%2B8";
			Properties info = new Properties();
			info.put("user","root");
			info.put("password", "hq441521hq");
			con = driver.connect(url, info);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return con;
		}
		
	}
    
    /**
    * �ر����ݿ�����
    */
    public static void close() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				con =null;
			}
		}
	}
    
   
    
    public int InsertUpdateDelete(String SQL,String[] messages) {
    	int result = 0;
    	try {
			PreparedStatement pstm = DBTool.ConnectSQL().prepareStatement(SQL);
			for(int i = 1;i<=messages.length;i++) {
				pstm.setString(i, messages[i-1]);
			}
			System.out.println(pstm.toString());
			result = pstm.executeUpdate();
			DBTool.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return result;
    };
    
    
    public ResultSet SelectNoParameter(String SQL) {
    	ResultSet res = null;
    	try {
			PreparedStatement pstm = DBTool.ConnectSQL().prepareStatement(SQL);
			res = pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
    }
    
    /**
     * 
     * @param SQL	sql���
     * @param messages	�����б�
     * @return
     */
    public ResultSet SelectWithParameter(String SQL,String[] messages) {
    	ResultSet res = null;
    	try {
			PreparedStatement pstm = DBTool.ConnectSQL().prepareStatement(SQL);
			for(int i = 1;i<=messages.length;i++) {
				pstm.setString(i, messages[i-1]);
			}
			res = pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
    }
   
    

}
