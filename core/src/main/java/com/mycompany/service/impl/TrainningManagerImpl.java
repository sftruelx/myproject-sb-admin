package com.mycompany.service.impl;

import com.mycompany.dao.TrainningDao;
import com.mycompany.model.Trainning;
import com.mycompany.service.TrainningManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liaoxiang on 2016/4/13.
 */

@Service
public class TrainningManagerImpl extends GenericManagerImpl<Trainning, Long> implements TrainningManager {

    TrainningDao trainningDao;

    @Autowired
    public TrainningManagerImpl(TrainningDao trainningDao) {
        super(trainningDao);
        this.trainningDao = trainningDao;
    }

}
