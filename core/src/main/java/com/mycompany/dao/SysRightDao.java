package com.mycompany.dao;

import com.mycompany.model.SysRight;

import java.util.List;

/**
 * Created by liaoxiang on 2016/4/7.
 */
public interface SysRightDao  extends GenericDao<SysRight, Long> {
    List<SysRight> getRights(SysRight sysRight);

}
