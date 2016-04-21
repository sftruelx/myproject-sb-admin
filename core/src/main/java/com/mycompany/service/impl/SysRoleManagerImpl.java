package com.mycompany.service.impl;

import com.mycompany.dao.RoleCopyDao;
import com.mycompany.dao.SysRoleDao;
import com.mycompany.model.RoleCopy;
import com.mycompany.model.SysRole;
import com.mycompany.service.RoleCopyManager;
import com.mycompany.service.SysRoleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liaoxiang on 2016/4/13.
 */

@Service
public class SysRoleManagerImpl extends GenericManagerImpl<SysRole, Long> implements SysRoleManager {

    SysRoleDao roleDao;

    @Autowired
    public SysRoleManagerImpl(SysRoleDao roleDao) {
        super(roleDao);
        this.roleDao = roleDao;
    }

}
