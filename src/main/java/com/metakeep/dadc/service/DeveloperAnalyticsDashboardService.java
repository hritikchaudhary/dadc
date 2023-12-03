package com.metakeep.dadc.service;

import com.metakeep.dadc.dto.AnalyticsDTO;
import com.metakeep.dadc.model.Analytics;
import com.metakeep.dadc.repository.AnalyticsRepository;
import com.metakeep.dadc.response.AnalyticsCountResponse;
import com.metakeep.dadc.response.AnalyticsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public AnalyticsResponse getStats(Pageable pageable, LocalDate sDate, LocalDate eDate) {
        Page<Analytics> analytics;
        LocalDateTime startDate = sDate.atStartOfDay();
        LocalDateTime endDate = eDate.atTime(23, 59, 59, 999999999);
        if (endDate != null && startDate == null) {
            analytics = analyticsRepository.findByCreatedAtBefore(endDate, pageable);
        } else if (startDate != null && endDate != null) {
            analytics = analyticsRepository.findByCreatedAtBetween(startDate, endDate, pageable);
        } else if (startDate != null) {
            LocalDateTime now = LocalDateTime.now();
            analytics = analyticsRepository.findByCreatedAtBetween(startDate, now, pageable);
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
            if (!item.getStatus().equals("Failure")) {
                totalFailures++;
            }
            dto.setStatus(item.getStatus());
            dto.setResponse(item.getResponse());
            dto.setUserID(item.getUserID());
            analyticsDTO.add(dto);
        }
        AnalyticsResponse response = new AnalyticsResponse();
        response.setAnalyticsDTOList(analyticsDTO);
        response.setTotalResults(analyticsRepository.countCreatedAtBetween(startDate, endDate));
        response.setUniqueUsers(analyticsRepository.countDistinctUserIdsBetween(startDate, endDate));
        response.setTotalFailures(totalFailures);
        response.setPageNumber(analytics.getNumber());
        response.setPageSize(analytics.getSize());
        response.setTotalPages(analytics.getTotalPages());
        return response;
    }

    public AnalyticsCountResponse getStatsByDate(LocalDate sDate, LocalDate eDate) {
        LocalDateTime startDate = sDate.atStartOfDay();
        LocalDateTime endDate = eDate.atTime(23, 59, 59, 999999999);
        AnalyticsCountResponse analyticsCountResponse = new AnalyticsCountResponse();
        List<DateRange> result = divideDateRange(startDate, endDate);

        List<String> labels = getLabels(result);
        List<Long> uniqueUsers = new ArrayList<>();
        List<Long> totalNumberOfCalls = new ArrayList<>();
        List<Long> totalNumberOfFailures = new ArrayList<>();

        for (DateRange subRange : result) {
            long uniqueUsersInRange = analyticsRepository.countDistinctUserIdsBetween(subRange.start, subRange.end);
            long totalNumberOfCallsInRange = analyticsRepository.countCreatedAtBetween(subRange.start, subRange.end);
            long totalNumberOfFailuresInRange = analyticsRepository.countFailureRecordsBetweenDates(subRange.start, subRange.end);
            uniqueUsers.add(uniqueUsersInRange);
            totalNumberOfCalls.add(totalNumberOfCallsInRange);
            totalNumberOfFailures.add(totalNumberOfFailuresInRange);

        }

        analyticsCountResponse.setChartLabels(labels);
        analyticsCountResponse.setUniqueUsers(uniqueUsers);
        analyticsCountResponse.setTotalNumberOfCalls(totalNumberOfCalls);
        analyticsCountResponse.setTotalNumberOfFailures(totalNumberOfFailures);
        return analyticsCountResponse;
    }


    public List<DateRange> divideDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        List<DateRange> subRanges = new ArrayList<>();

        Duration duration = Duration.between(startDate, endDate);

        // Define thresholds for range subdivisions
        Duration shortRangeThreshold = Duration.ofDays(10);
        Duration veryShortRangeThreshold = Duration.ofHours(48);

        if (duration.compareTo(veryShortRangeThreshold) < 0) {
            // If range is very short (< 48 hours), divide into hourly sub-ranges
            long totalSubRanges = 10; // Maximum of 10 sub-ranges
            Duration subRangeDuration = duration.dividedBy(totalSubRanges); // Duration for each sub-range

            for (int i = 0; i < totalSubRanges; i++) {
                LocalDateTime tempStartDate = startDate.plus(subRangeDuration.multipliedBy(i));
                LocalDateTime tempEndDate = tempStartDate.plus(subRangeDuration).isAfter(endDate) ?
                        endDate : tempStartDate.plus(subRangeDuration);
                subRanges.add(new DateRange(tempStartDate, tempEndDate));
            }
        } else if (duration.compareTo(shortRangeThreshold) < 0) {
            // If range is short (< 10 days), divide into daily sub-ranges
            LocalDateTime tempStartDate = startDate;
            LocalDateTime tempEndDate = tempStartDate.plusDays(1).withHour(0).withMinute(0).withSecond(0).minusNanos(1);

            while (tempStartDate.isBefore(endDate)) {
                if (tempEndDate.isAfter(endDate)) {
                    tempEndDate = endDate;
                }
                subRanges.add(new DateRange(tempStartDate, tempEndDate));
                tempStartDate = tempEndDate.plusNanos(1);
                tempEndDate = tempStartDate.plusDays(1).withHour(0).withMinute(0).withSecond(0).minusNanos(1);
            }
        } else {
            // Divide into 10 equal sub-ranges
            Duration subRangeDuration = duration.dividedBy(10);
            LocalDateTime tempStartDate = startDate;

            for (int i = 0; i < 10; i++) {
                LocalDateTime tempEndDate = tempStartDate.plus(subRangeDuration);
                if (tempEndDate.isAfter(endDate)) {
                    tempEndDate = endDate;
                }
                subRanges.add(new DateRange(tempStartDate, tempEndDate));
                tempStartDate = tempEndDate;
            }
        }


        return subRanges;
    }

    public List<String> getLabels(List<DateRange> subRanges) {
        List<String> labels = new ArrayList<>();

        for (DateRange subRange : subRanges) {
            Duration duration = Duration.between(subRange.start, subRange.end);
            DateTimeFormatter formatter;

            // If duration is greater than 1 day
            if (duration.toDays() > 1) {
                formatter = DateTimeFormatter.ofPattern("MM-dd");
                labels.add(subRange.start.format(formatter) + " to " + subRange.end.format(formatter));
            }
            // If duration is exactly 1 day (>= 23 hours)
            else if (duration.toHours() >= 23) {
                formatter = DateTimeFormatter.ofPattern("MM-dd");
                labels.add(subRange.start.format(formatter));
            }
            // If duration is more than 1 hour but less than 23 hours
            else if (duration.toHours() >= 1) {
                formatter = DateTimeFormatter.ofPattern("HH:mm");
                labels.add(subRange.start.format(formatter) + " to " + subRange.end.format(formatter));
            }
            // If duration is less than 1 hour
            else {
                formatter = DateTimeFormatter.ofPattern("HH:mm");
                labels.add(subRange.start.format(formatter) + " to " + subRange.end.plusSeconds(1).format(formatter));
            }
        }


        return labels;
    }


    class DateRange {
        private final LocalDateTime start;
        private final LocalDateTime end;

        public DateRange(LocalDateTime start, LocalDateTime end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + " - " + end + "]";
        }
    }
}
