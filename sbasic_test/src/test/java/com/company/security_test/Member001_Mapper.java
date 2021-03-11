package com.company.security_test;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class Member001_Mapper {
	
	@Setter(onMethod_= {@Autowired})
	private DataSource ds;
	
	@Test
	public void testDataSource() throws Exception{
		Connection conn = null;
		try { conn = ds.getConnection(); log.info(conn);}
		catch(Exception e) {fail(e.getMessage());}
		finally {
			if(conn!=null) {try{conn.close();} catch(Exception e) {e.printStackTrace();}}
		}
		
	}
	
	@Test
	public void testInsertMember() {
		PasswordEncoder pwencoder = new BCryptPasswordEncoder(); // ##
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(" insert into users (userid, userpw) values (?,?) ");
			pstmt.setString(1, "member");
			pstmt.setString(2, pwencoder.encode("member"));
			pstmt.executeUpdate();
		} catch (Exception e) {e.printStackTrace();
		} finally {
			if(pstmt!=null) {try{pstmt.close();} catch(Exception e) {e.printStackTrace();}}
			if(conn!=null) {try{conn.close();} catch(Exception e) {e.printStackTrace();}}
		}
	}
	

	@Test
	public void testInsertAuth() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(" insert into uauthorities (userid, auth) values (?,?) ");
			pstmt.setString(1, "member");
			pstmt.setString(2, "ROLE_MEMBER"); // ##
			pstmt.executeUpdate();
		} catch (Exception e) {e.printStackTrace();
		} finally {
			if(pstmt!=null) {try{pstmt.close();} catch(Exception e) {e.printStackTrace();}}
			if(conn!=null) {try{conn.close();} catch(Exception e) {e.printStackTrace();}}
		}
	}

}
