package com.company.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.mapper.Step001Mapper;
import com.company.mapper.Step002Mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class DB004_Mapper {
	@Setter(onMethod_= {@Autowired})
	private Step001Mapper mapper1; //src/main/java/com.company.mapper/Step001Mapper 인터페이스 생성 & src/main/resources > Step001Mapperxml
	@Setter(onMethod_= {@Autowired})
	private Step002Mapper mapper2;
	
	@Test
	public void test1() {
		log.info("...................1:" + mapper1.insertTodo("test1"));
	}

	@Test
	public void test2() {
		log.info("...................2:" + mapper2.insertTodo("test2"));
	}
}
