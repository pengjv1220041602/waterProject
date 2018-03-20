package com.water.service;

import java.util.List;

import com.water.pojo.SysNode;

public interface SysNodeService {
	/**
	 * 获取对应的节点
	 * @param sysNode
	 * @return
	 */
	List<SysNode> qryNodesToCondition(SysNode sysNode);
	
	/**
	 * 得到所有的树节点
	 * @return
	 */
	List<List<SysNode>> getAllSysNodes(); 
}
