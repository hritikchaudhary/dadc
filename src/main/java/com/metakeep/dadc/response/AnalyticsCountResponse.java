package com.metakeep.dadc.response;

import java.util.List;

public class AnalyticsCountResponse {

    private List<Long> uniqueUsers;

    private List<Long> totalNumberOfCalls;

    private List<Long> totalNumberOfFailures;

    private List<String> chartLabels;


    public List<Long> getUniqueUsers() {
        return uniqueUsers;
    }

    public void setUniqueUsers(List<Long> uniqueUsers) {
        this.uniqueUsers = uniqueUsers;
    }

    public List<Long> getTotalNumberOfCalls() {
        return totalNumberOfCalls;
    }

    public void setTotalNumberOfCalls(List<Long> totalNumberOfCalls) {
        this.totalNumberOfCalls = totalNumberOfCalls;
    }

    public List<Long> getTotalNumberOfFailures() {
        return totalNumberOfFailures;
    }

    public void setTotalNumberOfFailures(List<Long> totalNumberOfFailures) {
        this.totalNumberOfFailures = totalNumberOfFailures;
    }

    public List<String> getChartLabels() {
        return chartLabels;
    }

    public void setChartLabels(List<String> chartLabels) {
        this.chartLabels = chartLabels;
    }
}
