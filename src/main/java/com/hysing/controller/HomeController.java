package com.hysing.controller;

import com.hysing.entity.Candidate;
import com.hysing.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private CandidateService candidateService;

    //    @RequestMapping(method = RequestMethod.GET)
//    public String home(ModelMap modelMap) {
//        modelMap.addAttribute("candidateList", candidateService.findAllCandidate().get(0).toString());
//        return "index";
//    }
    @RequestMapping("/")
    public String index(ModelMap map) {
        map.put("candidateList", candidateService.findAllCandidate());
        return "dashboard";
    }

}
