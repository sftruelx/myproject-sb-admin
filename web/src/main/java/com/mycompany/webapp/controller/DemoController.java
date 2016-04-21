package com.mycompany.webapp.controller;

import com.mycompany.dao.SearchException;
import com.mycompany.model.Patient;
import com.mycompany.service.PatientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liaoxiang on 2016/4/14.
 */


@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    PatientManager patientManager;


    @RequestMapping(value = "/test")
    public String test() {
        return "/demo/test";
    }

    @RequestMapping(value = "/form")
    public String form() {
        return "/demo/form";
    }

    @RequestMapping(value = "/flot")
    public String flot() {
        return "/demo/flot";
    }

    @RequestMapping(value = "/morris")
    public String morris() {
        return "/demo/morris";
    }

    @RequestMapping(value = "/tables")
    public String tables() {
        return "/demo/tables";
    }

    @RequestMapping(value = "/dispatch")
    public String dispatch() {
        return "/demo/dispatch";
    }

    @RequestMapping(value = "/lore")
    public String lore() {
        return "/demo/lore";
    }


    @RequestMapping(value = "/guideList/{id}")
    public ModelAndView guideList(@PathVariable Long id) {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute("patient_id", id);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");
            model.addAttribute("dateStr",format.format(new Date()));
            Patient patient = patientManager.get(id);
            patient.setStatus(3);
            patient = patientManager.save(patient);
            model.addAttribute(patient);
        } catch (SearchException se) {
            se.printStackTrace();
        }

        return new ModelAndView("demo/guideList", model.asMap());
    }

    @RequestMapping(value = "/bind")
    public ModelAndView bind(String openId) {
        Map model = new HashMap();
        model.put("openId", openId);
        Patient patient = patientManager.findByOpenID(openId);
        if (patient != null) {
            model.put("patient", patient);
        }
        return new ModelAndView("demo/bind", model);
    }

    @RequestMapping(value = "/trainning")
    public String trainning() {
        return "/demo/trainning";
    }

    @RequestMapping(value = "/guide")
    public ModelAndView guide(Patient patient) {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(patientManager.get(patient.getId()));
            model.addAttribute("patient_id", patient.getId());
        } catch (SearchException se) {

        }
        return new ModelAndView("demo/guide", model.asMap());
    }

    @RequestMapping(value = "/nutritionalDiet")
    public String nutritionalDiet() {
        return "/demo/nutritionalDiet";
    }

    @RequestMapping(value = "/noReport")
    public String noReport() {
        return "/demo/noReport";
    }


}
