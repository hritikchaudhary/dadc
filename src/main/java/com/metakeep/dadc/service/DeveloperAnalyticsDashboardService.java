package com.metakeep.dadc.service;

import org.springframework.stereotype.Service;

@Service
public class DeveloperAnalyticsDashboardService {
    public String helloService(String userID){
        return "Hello, World! " + userID;
    }
}
