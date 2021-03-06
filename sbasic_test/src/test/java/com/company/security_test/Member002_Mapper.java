package com.company.security_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.mapper.UsersMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
@Log4j
public class Member002_Mapper {

	@Setter(onMethod_ = @Autowired)
	private UsersMapper mapper;

 
	@Test
	public void tetGetTime2() { 
		log.info(mapper.read_security("member"));
	}
}
