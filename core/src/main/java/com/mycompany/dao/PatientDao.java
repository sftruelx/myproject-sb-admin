package com.mycompany.dao;

import com.mycompany.model.Patient;
import com.mycompany.model.Trainning;
import com.mycompany.util.Pagination;
import com.mycompany.util.QueryObject;


/**
 * Created by liaoxiang on 2016/4/13.
 */
public interface PatientDao extends GenericDao<Patient, Long> {

    Pagination findListByCondition(QueryObject queryObject, Patient patient);

    Patient findByNameAndMobile(String name, String mobile);

    Patient findByOpenId(String openId);

    public Trainning findByPatientId(Long patientId);
}
