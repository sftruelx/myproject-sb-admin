package com.mycompany.dao;

import java.util.List;

import com.mycompany.model.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;


public interface SysUserDao extends GenericDao<SysUser, Long> {

	Page<SysUser> getByCondition(SysUser sysUserQueryDTO);

	List<SysUser> findManager();

	SysUser loadUserByUsername(String username);

}
