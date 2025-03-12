package practice;

import java.sql.Connection;
import java.sql.PreparedStatement;

import shop.m_dbinfo;

public class m_practice {
	Connection con = null;
	PreparedStatement ps = null;
	m_dbinfo dbinfo = new m_dbinfo();
	String sql = "";
	int result = 0;
}
