package com.handle;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.tempuri.IService1;
import org.tempuri.IService1Proxy;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.db.DBconn;
import com.test.A;

public class CheckHandle {
	public void insertLog(String batch_id, String onno, String begintime,
			String endtime, String flag) {
		try {
			DBconn db = new DBconn();
			Connection con = null;
			PreparedStatement ps = null;
			String sql = "insert into check_mxb_logs  (log_id, batch_id, on_no, flag, begintime, endtime) values  (ax.nextval, '"
					+ batch_id
					+ "','"
					+ onno
					+ "', '"
					+ flag
					+ "', TO_DATE('"
					+ begintime
					+ "', 'YYYY-MM-DD HH24:MI:SS'),TO_DATE('"
					+ endtime + "', 'YYYY-MM-DD HH24:MI:SS'))";
			con = db.getYlCon();
			ps = con.prepareStatement(sql);
			ps.execute();
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<A> checkmxb1() {
		ArrayList<A> onnos = new ArrayList<A>();
		DBconn db = new DBconn();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "";
		try {

			con = db.getYlCon();
			con.setAutoCommit(false);
			String tempsql = " and t.member_id = mem.member_id    and t.ds = mem.ds   and t.flag='1'   and mem.assist_type || mem.o_asort <> '000' and t.ds='1' and rownum<=100";
			sql = "select func_aac00215_18(mem.paperid) as idno,  mem.membername, "
					+ " mem.familyno as fn,  mem.ssn,  t.ssn1, "
					+ " t.ssn2,  t.ssn3, decode(mem.assist_type || mem.o_asort,  '000', "
					+ " '0',  '100', '1',  '110',  '1', '111',  '2',  '0') as stat ,mem.member_id,mem.ds "
					+ " from test_ssn t, member_baseinfo mem where 1=1  "
					+ tempsql + " and 1=1";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				A e = new A();
				e.setFn(rs.getString("fn"));
				e.setIdcard(rs.getString("idno"));
				e.setStat(rs.getString("stat"));
				e.setMembername(rs.getString("membername"));
				e.setMemberid(rs.getString("member_id"));
				e.setDs(rs.getString("ds"));
				onnos.add(e);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != rs) {
					rs.close();
				}
				if (null != ps) {
					ps.close();
				}
				if (null != con) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return onnos;
	}

	public void updateTestssn(A a) {
		try {
			DBconn db = new DBconn();
			Connection con = null;
			PreparedStatement ps = null;

			String ss1 = a.getSs1();
			String ss2 = a.getSs2();
			String ss3 = a.getSs3();

			if (null == ss1 || "".equals(ss1) || "null".equals(ss1)) {
				ss1 = "";
			}
			if (null == ss2 || "".equals(ss2) || "null".equals(ss2)) {
				ss2 = "";
			}
			if (null == ss3 || "".equals(ss3) || "null".equals(ss3)) {
				ss3 = "";
			}

			String sql = "update test_ssn t set t.ssn1='"
					+ ss1
					+ "' ,t.ssn2='"
					+ ss2
					+ "',t.ssn3='"
					+ ss3
					+ "' ,  t.ctime=sysdate , t.utime=sysdate ,t.flag='2'  where t.member_id='"
					+ a.getMemberid() + "' and t.ds='" + a.getDs() + "'";
			System.out.println(sql);
			con = db.getYlCon();
			ps = con.prepareStatement(sql);
			ps.execute();
			sql = "update member_baseinfo mem set mem.ssn = '" + ss1
					+ "' where mem.member_id='" + a.getMemberid()
					+ "' and mem.ds='" + a.getDs() + "'";
			System.out.println(sql);
			if ("1".equals(a.getDs())) {
				sql = "update familymember@cs fm set fm.indi_id='" + ss1
						+ "' where fm.fm_id='" + a.getMemberid() + "'";
				System.out.println(sql);
				ps = con.prepareStatement(sql);
				ps.execute();
			}
			if ("2".equals(a.getDs())) {
				sql = "update familymember@nc fm set fm.indi_id='" + ss1
						+ "' where fm.fm_id='" + a.getMemberid() + "'";
				System.out.println(sql);
				ps = con.prepareStatement(sql);
				ps.execute();
			}

			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> checkmxb() {
		ArrayList<String> onnos = new ArrayList<String>();
		DBconn db = new DBconn();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		String sql = "";
		try {

			con = db.getYlCon();
			con.setAutoCommit(false);
			sql = "select distinct (substr(t.familyno, 1, 10))  from ybjk_in_mxbry t";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				onnos.add(rs.getString(1));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != rs) {
					rs.close();
				}
				if (null != ps) {
					ps.close();
				}
				if (null != rs1) {
					rs.close();
				}
				if (null != ps1) {
					ps.close();
				}
				if (null != con) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return onnos;
	}

	@SuppressWarnings("resource")
	public void checkone() throws Exception {
		System.out.println("开始时间" + new Date(System.currentTimeMillis()));
		IService1 iService1 = new IService1Proxy();
		ArrayList<A> onnos = new ArrayList<A>();
		DBconn db = new DBconn();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "";
		String fid = "";
		try {
			
			con = db.getCsCon();
			con.setAutoCommit(false);

			sql ="select tc.fid from temp_ccc tc where tc.flag = '0'  and rownum = 1";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()){
				fid=rs.getString(1);
			}
			System.out.println(fid);
			sql = "select a.* from (select func_15_18(fmi.fm_paperid) as idc, "
					+ " fmi.fm_name as n, "
					+ " fmi.f_familyno as fn, "
					+ " s1.ss_state as s1, "
					+ " s2.ss_state as s2, "
					+ " (case "
					+ " WHEN fmi.fm_personstate = '正常' and "
					+ " s1.ss_state = '在保户' and s2.ss_state = '在保户' THEN  '2' "
					+ " WHEN fmi.fm_personstate = '正常' and  "
					+ " s1.ss_state = '在保户' THEN '1' ELSE '0'  END) as ttt,  "
					+ " to_char(sysdate, 'yyyyMMdd') as stst, sysdate as t1,  sysdate as t2,  "
					+ " 0 as f, fmi.f_familyid ,fmi.fm_id "
					+ " from familymemberinfoall fmi "
					+ " left join salvationstatus s1 "
					+ " on fmi.f_familyid = s1.ss_ot_id "
					+ " and fn_checkidcard(fmi.fm_paperid) = 1 "
					+ " and fn_checkidcard(func_15_18(fmi.fm_paperid)) = 1 "
					+ " and s1.st_id = '1' " + " left join salvationstatus s2 "
					+ " on fmi.f_familyid = s2.ss_ot_id "
					+ " and fn_checkidcard(fmi.fm_paperid) = 1 "
					+ " and fn_checkidcard(func_15_18(fmi.fm_paperid)) = 1 "
					+ " and s2.st_id = '31' " + " where fmi.f_familyid  ='"+fid+"') a";
			System.out.println(sql);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			/*
			 * IDC 220204196306281517 N 高铁 FN 22020204040280 S1 停保户 S2 TTT 0
			 * STST 20150604 T1 2015/6/4 9:24:09 T2 2015/6/4 9:24:09 F 0 0 未处理 1
			 * 已处理 F_FAMILYID 210182 CCC_ID 10835481
			 */
			
			while (rs.next()) {
				A e = new A();
				e.setDs("1");
				e.setFn(rs.getString("FN"));
				e.setIdcard(rs.getString("IDC"));
				e.setTtt(rs.getString("TTT"));
				e.setStat(rs.getString("stst"));
				e.setMembername(rs.getString("N"));
				e.setS1(rs.getString("S1"));
				e.setS2(rs.getString("S2"));
				e.setFid(rs.getString("F_FAMILYID"));
				e.setMemberid(rs.getString("fm_id"));
				fid = e.getFid();
				onnos.add(e);
			}

			for (A s : onnos) {
				String a = "";
				a = iService1.setAssistStatusSingle(s.getIdcard(),
						s.getMembername(), s.getFn(), s.getStat(), "201506");
				sql = " insert into ccc (idc, n, fn, s1, s2, ttt, stst, ctime, utime, f, ccc_id, fid, context01) "
						+ " values ('"
						+ s.getIdcard()
						+ "', '"
						+ s.getMembername()
						+ "', '"
						+ s.getFn()
						+ "', '"
						+ s.getS1()
						+ "', '"
						+ s.getS2()
						+ "', '"
						+ s.getTtt()
						+ "', '"
						+ s.getStat()
						+ "', sysdate, sysdate, '1', cc.nextval, '"
						+ s.getFid() + "', '" + a + "') ";

				a = iService1.getMedicareInfoSingle(s.getIdcard(),
						s.getMembername());

				a = "<?xml version=\"1.0\" encoding=\"GB2312\"?>" + a + "";
				DocumentBuilderFactory factory = DocumentBuilderFactory
						.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				ByteArrayInputStream in = new ByteArrayInputStream(a.getBytes());
				Document doc = builder.parse(in);

				NodeList nls = doc.getElementsByTagName("医保编号");
				String ss1 = "";
				String ss2 = "";
				String ss3 = "";
				for (int i = 0; i < nls.getLength(); i++) {
					if (i == 0) {
						ss1 = nls.item(i).getTextContent();
						s.setSsn(ss1);
						s.setSs1(ss1);
					}
					if (i == 1) {
						ss2 = nls.item(i).getTextContent();
						s.setSs2(ss2);
					}
					if (i == 2) {
						ss3 = nls.item(i).getTextContent();
						s.setSs3(ss3);
					}
				}
				this.updateTestssn(s);

			}
			sql = "update temp_ccc   set flag = '1'  where temp_ccc.fid = '"
					+ fid + "' and temp_ccc.flag = '0'";
			System.out.println(sql);
			ps = con.prepareStatement(sql);
			ps.execute();
			con.commit();
			System.out.println("输出时间" + new Date(System.currentTimeMillis()));
		} catch (ClassNotFoundException | SQLException
				| ParserConfigurationException | SAXException | IOException e) {
			throw e;
		} finally {
			try {
				if (null != rs) {
					rs.close();
				}
				if (null != ps) {
					ps.close();
				}
				if (null != con) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
