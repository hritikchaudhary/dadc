package com.metakeep.dadc.controller;

import com.metakeep.dadc.response.AnalyticsResponse;
import com.metakeep.dadc.service.DeveloperAnalyticsDashboardService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class DeveloperAnalyticsDashboardController {

    DeveloperAnalyticsDashboardService developerAnalyticsDashboardService;

    public DeveloperAnalyticsDashboardController(DeveloperAnalyticsDashboardService developerAnalyticsDashboardService) {
        this.developerAnalyticsDashboardService = developerAnalyticsDashboardService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(String userID) {
        if (userID == null) {
            this.developerAnalyticsDashboardService.helloService(userID);
            return ResponseEntity.badRequest().body("Please provide User ID");
        }
        String response = this.developerAnalyticsDashboardService.helloService(userID);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/stats")
    public AnalyticsResponse getStats(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate) {
        Pageable pageable = PageRequest.of(page, size);
        return this.developerAnalyticsDashboardService.getStats(pageable, startDate, endDate);
    }
}
