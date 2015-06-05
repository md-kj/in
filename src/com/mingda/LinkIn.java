package com.mingda;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.tempuri.IService1;
import org.tempuri.IService1Proxy;

import com.db.DBconn;

public class LinkIn {
	public String link(String idcard, String membername, String familyno,
			String type, String date) {
		IService1 iService1 = new IService1Proxy();
		String result = "";

		Connection con = null;
		try {
			result = iService1.setAssistStatusSingle(idcard, membername,
					familyno, type, date);
			//result =result+"#"+iService1.getMedicareInfoSingle(idcard, membername);
			DBconn db = new DBconn();
			con = db.getYlCon();
			String sql = "insert into sync_logs   "
					+ "(logid, col1, col2, col3, col4, col5, col6, opertime) "
					+ " values   (ax.nextval, '" + idcard + "', '" + membername
					+ "', '" + familyno + "', '" + type + "', '" + date
					+ "','" + result + "', sysdate)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			ps.close();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != con) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public String link01() {
		IService1 iService1 = new IService1Proxy();
		String result = "";
		try {
			result = iService1.getMedicareInfoBatch((long) 1, "2202");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
}
