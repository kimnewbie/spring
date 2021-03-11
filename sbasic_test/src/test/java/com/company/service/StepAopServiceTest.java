package com.company.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class StepAopServiceTest {
	
	@Setter(onMethod_= {@Autowired})
	private TestService service;
	
	@Test
	public void test1() {
		log.info(".............................1-1:" + service);
		log.info(".............................1-2:" + service.getClass().getName());
	}
	@Test
	public void test2() throws Exception {
		log.info(".............................1-3:" + service.add("100", "200"));
	}
	/*

	public void test3() throws Exception {
		log.info(".............................2-1:" + service.add("100", "A"));
	}

	 */
}
