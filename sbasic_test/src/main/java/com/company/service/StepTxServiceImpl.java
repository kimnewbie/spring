package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.company.mapper.Step001Mapper;
import com.company.mapper.Step002Mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class StepTxServiceImpl implements StepTxService {
	
	@Setter(onMethod_= {@Autowired})
	private Step001Mapper mapper1;

	@Setter(onMethod_= {@Autowired})
	private Step002Mapper mapper2;
	
	@Transactional
	@Override
	public void addData(String value) throws Exception {
		try {
			log.info(".......................mapper1:");
			mapper1.insertTodo(value + "1차 입금중...");
			log.info(".......................mapper2:");
			mapper2.insertTodo(value + "2차 yoyo com");
		} catch(Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		
	}

}
