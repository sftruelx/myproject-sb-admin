package com.mycompany.webapp.controller;

import com.mycompany.model.Patient;
import com.mycompany.model.Trainning;
import com.mycompany.service.PatientManager;
import com.mycompany.service.TrainningManager;
import com.mycompany.util.Pagination;
import com.mycompany.util.QueryObject;
import com.mycompany.util.WeixinUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liaoxiang on 2016/4/15.
 */

@Controller
@ResponseBody
@RequestMapping("/demo")
public class DemoDataController {
    private static final String appid = "wx41c9698b8348b7d6";
    private static final String secret = "e46ce562057ad2ddf10fc243328c7c12";

    @Autowired
    PatientManager patientManager;

    @Autowired
    TrainningManager trainningManager;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping(value = "/getPatient")
    public Pagination getPatient(QueryObject query, Patient patient) {
        Pagination page = patientManager.findListByCondition(query, patient);
        return page;
    }

    @RequestMapping(value = "/addPatient")
    public Patient addPatient(Patient patient) throws ParseException {
        logger.info("", patient);
        patient.setStatus(1);
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        Date mydate= myFormatter.parse(patient.getBirthdayStr());
        patient.setBirthday(mydate);
        long day=(date.getTime()-mydate.getTime())/(24*60*60*1000) + 1;
        String year=new java.text.DecimalFormat("#").format(day/365f);
        patient.setAge(Integer.valueOf(year));
        patient.setCreateDate(new Date());
        patient = patientManager.save(patient);
        return patient;
    }

    @RequestMapping(value = "/addTrainning")
    public Trainning addTrainning(Trainning trainning) {
        logger.info("", trainning);
        Patient patient = patientManager.get(trainning.getPatient_id());
        patient.setStatus(4);
        patientManager.save(patient);
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

    @RequestMapping("/report")
    public ModelAndView report(HttpServletRequest request) {
        String openId = WeixinUtil.getOpenid(appid, secret, request);
        Patient p = patientManager.findByOpenID(openId);
        ModelMap model = new ModelMap();
        model.addAttribute("openId", openId);
        if (p == null) {
            return new ModelAndView("/demo/bind", model);
        } else {
            Trainning trainning = patientManager.findByPatientId(p.getId());
            if (trainning == null) {
                return new ModelAndView("/demo/noReport");
            } else {
                model.addAttribute(trainning);
                return new ModelAndView("/demo/report", model);
            }

        }
    }

}
