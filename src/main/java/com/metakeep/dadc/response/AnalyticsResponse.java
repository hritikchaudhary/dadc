package com.metakeep.dadc.response;

import com.metakeep.dadc.dto.AnalyticsDTO;

import java.util.List;

public class AnalyticsResponse {
    private List<AnalyticsDTO> analyticsDTO;
    private long totalResults;
    private long uniqueUsers;
    private long totalFailures;
    private int pageNumber;
    private int pageSize;
    private int totalPages;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalFailures() {
        return totalFailures;
    }

    public void setTotalFailures(long totalFailures) {
        this.totalFailures = totalFailures;
    }

    public long getUniqueUsers() {
        return uniqueUsers;
    }

    public void setUniqueUsers(long uniqueUsers) {
        this.uniqueUsers = uniqueUsers;
    }

    public List<AnalyticsDTO> getAnalyticsDTOList() {
        return analyticsDTO;
    }

    public void setAnalyticsDTOList(List<AnalyticsDTO> analyticsDTOList) {
        this.analyticsDTO = analyticsDTOList;
    }

    public long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(long totalResults) {
        this.totalResults = totalResults;
    }

}
