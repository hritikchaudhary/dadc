package com.metakeep.dadc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.metakeep.dadc.service.DeveloperAnalyticsDashboardService;

@RestController
public class DeveloperAnalyticsDashboardController {

    DeveloperAnalyticsDashboardService developerAnalyticsDashboardService;
    public DeveloperAnalyticsDashboardController(DeveloperAnalyticsDashboardService developerAnalyticsDashboardService) {
        this.developerAnalyticsDashboardService = developerAnalyticsDashboardService;
    }

    @GetMapping("/hello")
    public String hello(String userID){
        return this.developerAnalyticsDashboardService.helloService(userID);
    }
}
