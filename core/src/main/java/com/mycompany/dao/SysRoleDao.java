package com.mycompany.dao;


import com.mycompany.model.SysRole;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SysRoleDao extends GenericDao<SysRole, Long> {

	Page<SysRole> getByCondition(SysRole sysRoleQueryDTO);


}
