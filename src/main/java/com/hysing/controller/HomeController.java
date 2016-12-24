package com.hysing.controller;

import com.hysing.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    private CandidateService candidateService;

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
//        entity.addAttribute("candidate", candidateService.findAllCandidate());
        return candidateService.findAllCandidate().get(0).toString();
    }
}
