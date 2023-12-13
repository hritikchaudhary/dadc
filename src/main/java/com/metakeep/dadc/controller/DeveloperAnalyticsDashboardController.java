package com.metakeep.dadc.controller;

import com.metakeep.dadc.response.AnalyticsCountResponse;
import com.metakeep.dadc.response.AnalyticsResponse;
import com.metakeep.dadc.service.DeveloperAnalyticsDashboardService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class DeveloperAnalyticsDashboardController {

    DeveloperAnalyticsDashboardService developerAnalyticsDashboardService;

    public DeveloperAnalyticsDashboardController(DeveloperAnalyticsDashboardService developerAnalyticsDashboardService) {
        this.developerAnalyticsDashboardService = developerAnalyticsDashboardService;
    }

    @PostMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam(required = false) String userID, @RequestParam(required = false) LocalDate createdAt) {
        if (userID == null || userID.isEmpty()) {
            String response = this.developerAnalyticsDashboardService.helloService(userID, createdAt);
            if (response.contains("API limit of 30 reached for")) {
                return ResponseEntity.status(429).body(response);
            }
            return ResponseEntity.badRequest().body(response);
        }
        String response = this.developerAnalyticsDashboardService.helloService(userID, createdAt);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/stats")
    public AnalyticsResponse getStats(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate,
            @RequestParam(required = false) String sortColumn,
            @RequestParam(defaultValue = "desc") String sortOrder) {

        Sort.Direction direction = sortOrder.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort sort = Sort.by(direction, sortColumn != null ? sortColumn : "createdAt");

        Pageable pageable = PageRequest.of(page, size, sort);
        return this.developerAnalyticsDashboardService.getStats(pageable, startDate, endDate);
    }

    @GetMapping("/statsByDate")
    public AnalyticsCountResponse getStats(@RequestParam(required = true) LocalDate startDate,
                                           @RequestParam(required = true) LocalDate endDate) {
        return this.developerAnalyticsDashboardService.getStatsByDate(startDate, endDate);
    }
}
