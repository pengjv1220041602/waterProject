package com.water.mapper;

import java.util.List;

import com.water.pojo.SysNode;

/**
 * 
 * @author Zhangpengju
 *
 */
public interface SysNodeMapper {
	List<SysNode> qryNodesToCondition(SysNode SysNode);
}
