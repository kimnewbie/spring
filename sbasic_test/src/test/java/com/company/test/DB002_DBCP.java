package com.company.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}) // 여기 설정해야해
@Log4j
public class DB002_DBCP {
	
	@Setter(onMethod_= {@Autowired})
	private DataSource ds;
	
	@Test
	public void test() {
		try {
			Connection conn = ds.getConnection();
			if(conn!=null) {log.info("................DB002 DBCP : " + conn);}
		} catch ( Exception e ) {e.printStackTrace();}
	}

}
