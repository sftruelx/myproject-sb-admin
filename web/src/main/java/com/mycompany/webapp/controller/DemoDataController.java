package com.mycompany.webapp.controller;

import com.mycompany.model.Patient;
import com.mycompany.model.Trainning;
import com.mycompany.service.PatientManager;
import com.mycompany.service.TrainningManager;
import com.mycompany.util.Pagination;
import com.mycompany.util.QueryObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liaoxiang on 2016/4/15.
 */

@Controller
@ResponseBody
@RequestMapping("/demo")
public class DemoDataController {

    @Autowired
    PatientManager patientManager;

    @Autowired
    TrainningManager trainningManager;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/getPatient")
    public Pagination getPatient(QueryObject query, Patient patient) {
        Pagination page = patientManager.findListByCondition(query, patient);
        return page;
    }

    @RequestMapping(value = "/addPatient")
    public Patient addPatient(Patient patient) {
        logger.info("", patient);
        patient.setStatus(1);
        patient = patientManager.save(patient);
        return patient;
    }

    @RequestMapping(value = "/addTrainning")
    public Trainning addTrainning(Trainning trainning) {
        logger.info("", trainning);
        return trainningManager.save(trainning);
    }

    @RequestMapping(value = "/addBind")
    @ResponseBody
    public Map bindUser(HttpServletRequest request) {
        Map map = new HashMap();

        String num = request.getParameter("num");
        String name = request.getParameter("name");
        String openId = request.getParameter("openId");
        Patient patient = new Patient();
        patient.setName(name);
        patient.setMobile(num);
        patient.setOpenID(openId);

        Patient p = patientManager.bindOpenID(name, num, openId);
        if (p != null) {
            map.put("code", 0);
        } else {
            map.put("code", 1);
        }
        return map;
    }


    @RequestMapping(value = "/getPatientByID/{id}")
    public Patient getPatientByID(@PathVariable Long id) {
        logger.info(id.toString());
        return patientManager.get(id);
    }

}
