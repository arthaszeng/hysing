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

    @RequestMapping({"/", "/home"})
    public String index(ModelMap map) {

        return "home";
    }

}
