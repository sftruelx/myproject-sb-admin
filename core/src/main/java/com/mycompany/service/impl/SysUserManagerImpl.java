package com.mycompany.service.impl;

import com.mycompany.dao.SysUserDao;
import com.mycompany.model.SysUser;
import com.mycompany.service.SysUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserManagerImpl extends GenericManagerImpl<SysUser, Long> implements SysUserManager {
	@Autowired
	private SysUserDao sysUserDao;

	@Autowired
	public SysUserManagerImpl(SysUserDao sysUserDao) {
		super(sysUserDao);
		this.sysUserDao = sysUserDao;
	}


	@Override
	public SysUser loadUserByUsername(String username){
		return sysUserDao.loadUserByUsername(username);


	}



}
