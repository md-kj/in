package com.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.tempuri.IService1;
import org.tempuri.IService1Proxy;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Test {

	public static void main(String[] args) {
		IService1 iService1 = new IService1Proxy();
		try {
			String a = "";
			// String a
			// =iService1.getChronicDisePersonBatch((long)1,"22020101");
			a = iService1.getMedicareInfoSingle("220204197006033022", "–Ï–„Œ∞");
			System.out.println(a);
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			a = "<?xml version=\"1.0\" encoding=\"GB2312\"?>" + a + "";

			ByteArrayInputStream in = new ByteArrayInputStream(a.getBytes());
			Document doc = builder.parse(in);

			NodeList nls = doc.getElementsByTagName("“Ω±£±‡∫≈");
			String ss1 = "";
			String ss2 = "";
			String ss3 = "";
			for (int i = 0; i < nls.getLength(); i++) {
				if (i == 0) {
					ss1 = nls.item(i).getTextContent();
				}
				if (i == 1) {
					ss2 = nls.item(i).getTextContent();
				}
				if (i == 2) {
					ss3 = nls.item(i).getTextContent();
				}
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
