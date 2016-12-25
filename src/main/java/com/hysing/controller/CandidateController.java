package com.hysing.controller;

import com.hysing.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @RequestMapping("/candidate")
    public String getCandidateList(ModelMap map) {
        map.put("candidateList", candidateService.findAllCandidate());
        return "candidate";
    }

}
