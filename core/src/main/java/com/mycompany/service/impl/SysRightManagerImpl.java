package com.mycompany.service.impl;


import com.mycompany.dao.SysRightDao;
import com.mycompany.dao.SysRoleDao;
import com.mycompany.model.SysRight;
import com.mycompany.service.SysRightManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service("SysRightService")
public class SysRightManagerImpl extends GenericManagerImpl<SysRight, Long>  implements
		SysRightManager {

	private SysRightDao sysRightDao;


	@Autowired
	public SysRightManagerImpl(SysRightDao sysRightDao) {
		super(sysRightDao);
		this.sysRightDao = sysRightDao;
	}
	@Override
	public List<SysRight> loadRights(SysRight SysRight) {
		List<SysRight> resultList = this.sysRightDao.getRights(SysRight);

		return resultList;
	}


	
	@Override
	public List<SysRight> loadRightsByRole(SysRight SysRight) {
		List<SysRight> resultList = this.sysRightDao.getRights(SysRight);

		return resultList;
	}

	
}
