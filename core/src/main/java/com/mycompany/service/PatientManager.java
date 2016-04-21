package com.mycompany.service;

import com.mycompany.model.Patient;
import com.mycompany.model.Trainning;
import com.mycompany.util.Pagination;
import com.mycompany.util.QueryObject;


/**
 * Created by liaoxiang on 2016/4/13.
 */
public interface PatientManager extends GenericManager<Patient, Long>{

    Pagination findListByCondition(QueryObject queryObject,Patient patient);

    Patient bindOpenID(String name, String mobile, String openID);

    Patient findByOpenID(String openID);

    Trainning findByPatientId(Long patientId);
}
