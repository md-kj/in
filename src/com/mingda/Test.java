package com.mingda;

import java.rmi.RemoteException;

import org.tempuri.IService1;
import org.tempuri.IService1Proxy;

public class Test {
	public static void main(String[] args) {
		IService1 iService1 = new IService1Proxy();
		try {
			/*System.out.println(iService1.getChronicDisePersonBatch((long) 1,
					"220206"));*/
			System.out.println(iService1.getMedicareInfoBatch((long) 1, "220201"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
