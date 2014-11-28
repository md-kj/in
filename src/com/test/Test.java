package com.test;

import java.rmi.RemoteException;

import com.MingdaSoft.ServiceMainSoap;
import com.MingdaSoft.ServiceMainSoapProxy;

public class Test {

	public static void main(String[] args) {
		ServiceMainSoap sms =new ServiceMainSoapProxy();
		try {
			String v= sms.getDbbxScope("220204197005140029");
			v= sms.getDbbxScopeMinValue(1);
			System.out.println(v);
			System.out.println(v);
			System.out.println(v);
			System.out.println(v);System.out.println(v);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
