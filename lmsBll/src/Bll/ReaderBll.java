package Bll;

import java.util.List;

import Tool.ReaderDal;
import pojo.ReaderInfo;

public class ReaderBll {
	
	private ReaderDal readerDal =  new ReaderDal();
	
	
	public List<ReaderInfo> SelectAllReader(){
		return readerDal.SelectAllReader();
	}
	
	public List<ReaderInfo> SelectReader(String message,String selectType){
		List<ReaderInfo> readers = null;
		switch (selectType) {
		case "编号":		readers = readerDal.SelectReaderWithParameter(message, "ID");
			break;
		case "用户编号":		readers = readerDal.SelectReaderWithParameter(message, "readerID");
			break;
		case "姓名":		readers = readerDal.SelectReaderWithParameter(message, "name");
			break;
		case "性别":		readers = readerDal.SelectReaderWithParameter(message,"sex");
			break;
		}
		return readers;
	}

	
	
	public boolean Insert(ReaderInfo reader) {
		if (Integer.parseInt(reader.getMoney()) > 200) {
			reader.setMaxNum("5");
		}else if (Integer.parseInt(reader.getMoney()) > 100) {
			reader.setMaxNum("3");
		}
		reader.setNowNum("0");
		return isTrue(readerDal.Insert(reader));
	}
	
	
	public boolean Update(ReaderInfo reader) {
		if (Integer.parseInt(reader.getMoney()) > 200) {
			reader.setMaxNum("5");
		}else if (Integer.parseInt(reader.getMoney()) > 100) {
			reader.setMaxNum("3");
		}
		reader.setNowNum(SelectReader(reader.getID(), "编号").get(0).getNowNum());
		return isTrue(readerDal.Update(reader));
	}
	
	
	public boolean Delete(String readerID) {
		String ID = SelectReader(readerID, "用户编号").get(0).getID();
		return isTrue(readerDal.Delete(ID));
	}
	
	
	public boolean isTrue(int result) {
		if (result > 0) {
			return true;
		}
		return false;
	}
	
	
	
	public int[] setReaderAgeChartData() {
		int[] data = null;
		int data10_20 = 0;
		int data20_30 = 0;
		int data30_40 = 0;
		int data40_50 = 0;
		int data50_60 = 0;
		int data60_70 = 0;
		int data70_80 = 0;
		int data80_90 = 0;
		int data90_100 = 0;
		List<ReaderInfo> readers = SelectAllReader();
		for(ReaderInfo reader : readers) {
			int age = Integer.parseInt(reader.getAge());
			if(age > 90) {
				data90_100++;
			}else if (age > 80) {
				data80_90++;
			}else if (age > 70) {
				data70_80++;
			}else if (age > 60) {
				data60_70++;
			}else if (age > 50) {
				data50_60++;
			}else if (age > 40) {
				data40_50++;
			}else if (age > 30) {
				data30_40++;
			}else if (age > 20) {
				data20_30++;
			}else if (age > 10) {
				data10_20++;
			}
		}
		data = new int[] {data10_20,data20_30,data30_40,data40_50,data50_60,data60_70,data70_80,data80_90,data90_100};
		return data;
	}
	
	
	
	
	
}
