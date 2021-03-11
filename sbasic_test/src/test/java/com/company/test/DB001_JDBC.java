package com.company.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class DB001_JDBC {
	@Test
	public void test() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ouser","1111");
			log.info("jdbc 연동성공 : " + conn);
		} catch (Exception e) {e.printStackTrace();}
	}
}
