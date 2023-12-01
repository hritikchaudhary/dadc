package com.metakeep.dadc.service;

import com.metakeep.dadc.dto.AnalyticsDTO;
import com.metakeep.dadc.model.Analytics;
import com.metakeep.dadc.repository.AnalyticsRepository;
import com.metakeep.dadc.response.AnalyticsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DeveloperAnalyticsDashboardService {

    @Autowired
    private final AnalyticsRepository analyticsRepository;

    public DeveloperAnalyticsDashboardService(AnalyticsRepository analyticsRepository) {
        this.analyticsRepository = analyticsRepository;
    }

    public String helloService(String userID) {
        Analytics analytics = new Analytics();
        if (userID == null) {
            String error = "Please provide User ID";
            analytics.setErrorMessage(error);
            analytics.setCreatedAt(new Date());
            analytics.setResponse(error);
            analytics.setStatus("Failure");
            analyticsRepository.save(analytics);
            return error;
        }
        String response = "hello world";
        analytics.setCreatedAt(new Date());
        analytics.setUserID(userID);
        analytics.setRequest(userID);
        analytics.setResponse(response);
        analytics.setStatus("Success");
        analyticsRepository.save(analytics);
        return response;
    }

    public AnalyticsResponse getStats(Pageable pageable, LocalDate startDate, LocalDate endDate) {
        Page<Analytics> analytics;

        if (endDate != null && startDate == null) {
            analytics = analyticsRepository.findByCreatedAtBefore(endDate.atTime(23, 59, 59, 999999999), pageable);
        } else if (startDate != null && endDate != null) {
            analytics = analyticsRepository.findByCreatedAtBetween(startDate.atStartOfDay(), endDate.atTime(23, 59, 59, 999999999), pageable);
        } else if (startDate != null) {
            LocalDateTime now = LocalDateTime.now();
            analytics = analyticsRepository.findByCreatedAtBetween(startDate.atStartOfDay(), now, pageable);
        } else {
            analytics = analyticsRepository.findAll(pageable);
        }
        List<AnalyticsDTO> analyticsDTO = new ArrayList<>();
        long totalFailures = 0;
        for (Analytics item : analytics) {
            AnalyticsDTO dto = new AnalyticsDTO();
            dto.setCreatedAt(item.getCreatedAt());
            dto.setErrorMessage(item.getErrorMessage());
            dto.setRequest(item.getRequest());
            if (!item.getStatus().equals(HttpStatus.OK)) {
                totalFailures++;
            }
            dto.setStatus(item.getStatus());
            dto.setResponse(item.getResponse());
            dto.setUserID(item.getUserID());
            analyticsDTO.add(dto);
        }
        AnalyticsResponse response = new AnalyticsResponse();
        response.setAnalyticsDTOList(analyticsDTO);
        response.setTotalResults(analyticsRepository.count());
        response.setUniqueUsers(analyticsRepository.countDistinctUserIds());
        response.setTotalFailures(totalFailures);
        response.setPageNumber(analytics.getNumber());
        response.setPageSize(analytics.getSize());
        response.setTotalPages(analytics.getTotalPages());
        return response;
    }

}
