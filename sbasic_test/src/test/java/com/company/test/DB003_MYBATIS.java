package com.company.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class DB003_MYBATIS {
	@Setter(onMethod_= {@Autowired})
	private DataSource ds;
	
	@Setter(onMethod_= {@Autowired})
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void test() {
		try {
			log.info(".......................sqlFactory : " + sqlFactory);
			SqlSession session = sqlFactory.openSession();
			Connection conn = session.getConnection();
			log.info(".......................session : " + session);
			if(conn!=null) {log.info(".......................conn : " + conn);}
		} catch (Exception e) {e.printStackTrace();}
	}
}
