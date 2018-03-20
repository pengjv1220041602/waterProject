package com.water.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.water.constant.Constant;
import com.water.mapper.SysNodeMapper;
import com.water.pojo.SysNode;
import com.water.service.SysNodeService;
import com.water.util.StringUtils;

@Service
public class SysNodeServiceImpl implements SysNodeService{
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private SysNodeMapper sysNodeMapper;
	/**
	 * 得到父节点的子节点，如果没有父节点那么就返回所有父节点
	 */
	public List<SysNode> qryNodesToCondition(SysNode sysNode) {
		//得到日志类和名字
		logger.debug(this.getClass().getName()+":"+Thread.currentThread().getStackTrace()[1].getMethodName());
		if (StringUtils.isBlank(sysNode.getpId())) {
			sysNode.setpId(Constant.SysNodeConstant.PID);
		}
		sysNode.setFlag(Constant.EXIST_FLAG);
		List<SysNode> allNodes = sysNodeMapper.qryNodesToCondition(sysNode);
		return allNodes;
	}
	
	/**
	 * 得到所有的树节点,并且分为一级节点和二级节点
	 */
	public List<List<SysNode>> getAllSysNodes() {
		List<SysNode> allSysNodes = sysNodeMapper.qryNodesToCondition(new SysNode(Constant.EXIST_FLAG));
		Map<String, List<SysNode>> resultMap = new HashMap<String, List<SysNode>>();
		List<List<SysNode>> resultList = new ArrayList<List<SysNode>>();
		//遍历树
		for (SysNode sysNode : allSysNodes) {
			//如果父节点是1，那么是父节点,并将父节点加入到集合的第一位
			if (sysNode.getpId().equals(Constant.SysNodeConstant.PID)) {
				ArrayList<SysNode> listTemp = new ArrayList<SysNode>();
				listTemp.add(sysNode);
				resultMap.put(sysNode.getId(), listTemp);
			} else {
				//父节点不是1，是子节点，找到父节点并将这个子节点加到父节点的集合中，从第二位开始，都是子节点
				List<SysNode> listTemp = resultMap.get(sysNode.getpId());
				listTemp.add(sysNode);
				resultMap.put(sysNode.getId(), listTemp);
			}
		}
		for (Map.Entry<String, List<SysNode>> map : resultMap.entrySet()) {
			resultList.add(map.getValue());
		}
		return resultList;
	}

}
