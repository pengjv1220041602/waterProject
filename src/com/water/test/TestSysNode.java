package com.water.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.water.pojo.SysNode;
import com.water.service.SysNodeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")  
public class TestSysNode {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private SysNodeService syNodeService;
	
	@Test
	public void testGetSysNodes() {
		SysNode sysNode = new SysNode();
		sysNode.setpId("1");
		sysNode.setFlag("1");
		List<SysNode> sysNodes = syNodeService.qryNodesToCondition(sysNode);
		logger.debug("结果：");
		for (SysNode sysNode2 : sysNodes) {
			logger.debug(sysNode2);
		}
	}
}
