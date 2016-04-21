package com.mycompany.service.impl;

import com.mycompany.dao.PatientDao;
import com.mycompany.model.Patient;
import com.mycompany.service.PatientManager;
import com.mycompany.util.Pagination;
import com.mycompany.util.QueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liaoxiang on 2016/4/13.
 */

@Service
public class PatientManagerImpl extends GenericManagerImpl<Patient, Long> implements PatientManager {

    private PatientDao patientDao;

    @Autowired
    public PatientManagerImpl(PatientDao patientDao) {
        super(patientDao);
        this.patientDao = patientDao;
    }

    @Override
    public Pagination findListByCondition(QueryObject queryObject, Patient patient) {
        Pagination page = patientDao.findListByCondition(queryObject,patient);
        return page;
    }

    public Patient bindOpenID(String name, String mobile, String openID){
        Patient patient = patientDao.findByNameAndMobile(name, mobile);
        patient.setOpenID(openID);
        return patientDao.save(patient);
    }
}
