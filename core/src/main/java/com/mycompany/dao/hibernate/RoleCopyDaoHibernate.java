package com.mycompany.dao.hibernate;

import com.mycompany.dao.RoleCopyDao;
import com.mycompany.dao.SearchException;
import com.mycompany.model.RoleCopy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by liaoxiang on 2016/4/13.
 */

@Repository
public class RoleCopyDaoHibernate extends GenericDaoHibernate<RoleCopy, Long> implements RoleCopyDao {

    public RoleCopyDaoHibernate() {
        super(RoleCopy.class);
    }

}
