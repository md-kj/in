package com.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.tempuri.IService1;
import org.tempuri.IService1Proxy;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.handle.CheckHandle;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.test.A;

public class MainFrame {

	private JFrame frame;
	ArrayList<String> onnos = null;
	private JProgressBar progressBar;
	private Thread thread;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));
		
				JButton btnNewButton = new JButton("核对慢性病");
				btnNewButton.addActionListener(myal);
				frame.getContentPane().add(btnNewButton, "2, 2");
								progressBar = new JProgressBar();
								frame.getContentPane().add(progressBar, "4, 2");
								
										button = new JButton("核对身份");
										button.addActionListener(myal1);
										frame.getContentPane().add(button, "2, 6");
	}

	MyActionListener myal = new MyActionListener();

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			CheckHandle ckh = new CheckHandle();
			onnos = ckh.checkmxb();
			int max = onnos.size();
			int min = 0;

			progressBar.setMinimum(min);
			progressBar.setMaximum(max);
			MyRunner myr = new MyRunner();
			thread = new Thread(myr);
			thread.start();
		}

	}

	MyActionListener1 myal1 = new MyActionListener1();
	private ArrayList<A> onnos1;

	class MyActionListener1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			CheckHandle ckh = new CheckHandle();
			onnos1 = ckh.checkmxb1();
			int max = onnos1.size();
			int min = 0;

			progressBar.setMinimum(min);
			progressBar.setMaximum(max);
			MyRunner1 myr = new MyRunner1();
			thread = new Thread(myr);
			thread.start();
		}

	}

	IService1 iService1 = new IService1Proxy();
	private JButton button;

	class OperRunner implements Runnable {
		private int idx;

		public OperRunner(int idx) {
			this.idx = idx;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

		@Override
		public void run() {
			System.out.println(onnos.get(idx));

			try {
				String onno = onnos.get(idx);
				Date b = new Date(System.currentTimeMillis());
				String a = iService1.getChronicDisePersonBatch((long) 1, onno);
				Date e = new Date(System.currentTimeMillis());
				String flag = "0";
				if (a.indexOf("成功") > 0) {
					flag = "1";
				}
				CheckHandle ckh = new CheckHandle();
				ckh.insertLog("20150602", onno, sdf.format(b), sdf.format(e),
						flag);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}

		public int getIdx() {
			return idx;
		}

		public void setIdx(int idx) {
			this.idx = idx;
		}

	}

	class MyRunner implements Runnable {

		@Override
		public void run() {
			int max = progressBar.getMaximum();
			int min = progressBar.getMinimum();

			for (int i = min; i < max; i++) {
				OperRunner orr = new OperRunner(progressBar.getValue());
				int value = progressBar.getValue() + 1;
				progressBar.setValue(value);
				System.out.println("c:" + i + " d:" + value);
				try {
					SwingUtilities.invokeAndWait(orr);
				} catch (InterruptedException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class OperRunner1 implements Runnable {
		private int idx;

		public OperRunner1(int idx) {
			this.idx = idx;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

		@Override
		public void run() {
			System.out.println(onnos1.get(idx));

			try {
				A onno = onnos1.get(idx);
				// Date b = new Date(System.currentTimeMillis());
				String a = "";
				a = iService1.setAssistStatusSingle(onno.getIdcard(),
						onno.getMembername(), onno.getFn(), onno.getStat(),
						"201506");
				a = iService1.getMedicareInfoSingle(onno.getIdcard(),
						onno.getMembername());
				// Date e = new Date(System.currentTimeMillis());

				DocumentBuilderFactory factory = DocumentBuilderFactory
						.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();

				a = "<?xml version=\"1.0\" encoding=\"GB2312\"?>" + a + "";

				ByteArrayInputStream in = new ByteArrayInputStream(a.getBytes());
				Document doc = builder.parse(in);

				NodeList nls = doc.getElementsByTagName("医保编号");
				String ss1 = "";
				String ss2 = "";
				String ss3 = "";
				for (int i = 0; i < nls.getLength(); i++) {
					if (i == 0) {
						ss1 = nls.item(i).getTextContent();
						onno.setSsn(ss1);
						onno.setSs1(ss1);
					}
					if (i == 1) {
						ss2 = nls.item(i).getTextContent();
						onno.setSs2(ss2);
					}
					if (i == 2) {
						ss3 = nls.item(i).getTextContent();
						onno.setSs3(ss3);
					}
				}
				CheckHandle ckh = new CheckHandle();
				ckh.updateTestssn(onno);
			} catch (ParserConfigurationException | SAXException | IOException e) {
				e.printStackTrace();
			}
		}

		public int getIdx() {
			return idx;
		}

		public void setIdx(int idx) {
			this.idx = idx;
		}

	}

	class MyRunner1 implements Runnable {

		@Override
		public void run() {
			int max = progressBar.getMaximum();
			int min = progressBar.getMinimum();

			for (int i = min; i < max; i++) {
				OperRunner1 orr = new OperRunner1(progressBar.getValue());
				int value = progressBar.getValue() + 1;
				progressBar.setValue(value);
				System.out.println("c:" + i + " d:" + value);
				try {
					SwingUtilities.invokeAndWait(orr);
				} catch (InterruptedException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
