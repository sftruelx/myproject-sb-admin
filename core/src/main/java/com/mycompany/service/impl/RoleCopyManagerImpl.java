package com.mycompany.service.impl;

import com.mycompany.dao.RoleCopyDao;
import com.mycompany.model.RoleCopy;
import com.mycompany.service.RoleCopyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liaoxiang on 2016/4/13.
 */

@Service
public class RoleCopyManagerImpl extends GenericManagerImpl<RoleCopy, Long> implements RoleCopyManager {

    RoleCopyDao roleDao;

    @Autowired
    public RoleCopyManagerImpl(RoleCopyDao roleDao) {
        super(roleDao);
        this.roleDao = roleDao;
    }

}
