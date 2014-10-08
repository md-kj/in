package com.mingda;

import java.rmi.RemoteException;

import org.tempuri.IService1;
import org.tempuri.IService1Proxy;

public class LinkIn {
	public String link(String idcard, String membername, String familyno,
			String type, String date) {
		IService1 iService1 = new IService1Proxy();
		String result = "";
		try {
			result = iService1.setAssistStatusSingle(idcard, membername,
					familyno, type, date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
}
