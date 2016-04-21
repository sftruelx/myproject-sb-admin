package com.mycompany.service;

import java.util.List;

import com.mycompany.model.SysRight;


/**
 * Ȩ��ҵ���ӿ�
 * 
 * @author william
 * 
 */
public interface SysRightManager extends GenericManager<SysRight, Long> {

	/**
	 * ����Ȩ��
	 * 
	 * @return
	 */
	 List<SysRight> loadRights(SysRight sysRightQueryDTO);
	
	/**
	 * ���ݽ�ɫID����Ȩ��
	 */
	 List<SysRight> loadRightsByRole(SysRight sysRightQueryDTO);
	
}




