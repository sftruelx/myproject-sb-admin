package com.mycompany.dao.hibernate;

import com.mycompany.dao.SysRoleDao;
import com.mycompany.model.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public class SysRoleDaoHibernate extends GenericDaoHibernate<SysRole, Long> implements SysRoleDao {

	public SysRoleDaoHibernate() {
		super(SysRole.class);
	}

	@Override
	public Page<SysRole> getByCondition(final SysRole sysRoleQueryDTO) {
		return null;
	}


}
