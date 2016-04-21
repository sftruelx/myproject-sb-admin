package com.mycompany.dao.hibernate;

import java.util.List;
import com.mycompany.dao.SysRightDao;
import com.mycompany.model.SysRight;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class SysRightDaoHibernate extends GenericDaoHibernate<SysRight, Long> implements SysRightDao {

    public SysRightDaoHibernate() {
        super(SysRight.class);
    }

    @Override
    public List<SysRight> getRights(final SysRight sysRight) {

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT sysRight FROM SysRight sysRight");
        if (null != sysRight.getParent_id()) {
            sb.append(" WHERE sysRight.parent.id = :parentId");
        } else {
            sb.append(" WHERE sysRight.parent IS NULL");
        }
        sb.append(" ORDER BY sysRight.lastOperatorTime DESC");
        Query query = getSession().createQuery(sb.toString());
        if (null != sysRight.getParent_id()) {
            query.setParameter("parentId", sysRight.getParent_id());
        }

        return query.list();
    }

}
