package com.mycompany.dao.hibernate;


import com.mycompany.dao.SysUserDao;
import com.mycompany.model.SysUser;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class SysUserDaoHibernate extends GenericDaoHibernate<SysUser , Long> implements SysUserDao {


	public SysUserDaoHibernate() {
		super(SysUser.class);
	}
	@Override
	public Page<SysUser> getByCondition(final SysUser sysUserQueryDTO) {

		return null;
	}

	@Override
	public List<SysUser> findManager() {

		return null;
	}

	public SysUser loadUserByUsername(String username) throws UsernameNotFoundException {
		List users = getSession().createCriteria(SysUser.class).add(Restrictions.eq("usrName", username)).list();
		if (users == null || users.isEmpty()) {
			throw new UsernameNotFoundException("user '" + username + "' not found...");
		} else {
			return (SysUser) users.get(0);
		}
	}
}
