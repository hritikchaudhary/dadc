package com.metakeep.dadc.controller;

import com.metakeep.dadc.response.AnalyticsResponse;
import com.metakeep.dadc.service.DeveloperAnalyticsDashboardService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeveloperAnalyticsDashboardController {

    DeveloperAnalyticsDashboardService developerAnalyticsDashboardService;

    public DeveloperAnalyticsDashboardController(DeveloperAnalyticsDashboardService developerAnalyticsDashboardService) {
        this.developerAnalyticsDashboardService = developerAnalyticsDashboardService;
    }

    @GetMapping("/hello")
    public String hello(String userID) {
        return this.developerAnalyticsDashboardService.helloService(userID);
    }

    @GetMapping("/stats")
    public AnalyticsResponse getStats(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.developerAnalyticsDashboardService.getStats(pageable);
    }
}
