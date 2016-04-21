package com.mycompany.dao.hibernate;

import com.mycompany.dao.RoleCopyDao;
import com.mycompany.dao.TrainningDao;
import com.mycompany.model.RoleCopy;
import com.mycompany.model.Trainning;
import org.springframework.stereotype.Repository;

/**
 * Created by liaoxiang on 2016/4/13.
 */

@Repository
public class TrainningDaoHibernate extends GenericDaoHibernate<Trainning, Long> implements TrainningDao {

    public TrainningDaoHibernate() {
        super(Trainning.class);
    }

}
