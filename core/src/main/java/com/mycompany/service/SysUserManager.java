package com.mycompany.service;

import com.mycompany.model.SysUser;

public interface SysUserManager extends GenericManager<SysUser, Long>{


	SysUser loadUserByUsername(String username);

	
}
