package com.metakeep.dadc.response;

import java.util.List;

public class AnalyticsCountResponse {

    private List<Integer> uniqueUsers;

    private List<Integer> totalNumberOfCalls;

    private List<Integer> totalNumberOfFailures;

    private List<String> chartLabels;


    public List<Integer> getUniqueUsers() {
        return uniqueUsers;
    }

    public void setUniqueUsers(List<Integer> uniqueUsers) {
        this.uniqueUsers = uniqueUsers;
    }

    public List<Integer> getTotalNumberOfCalls() {
        return totalNumberOfCalls;
    }

    public void setTotalNumberOfCalls(List<Integer> totalNumberOfCalls) {
        this.totalNumberOfCalls = totalNumberOfCalls;
    }

    public List<Integer> getTotalNumberOfFailures() {
        return totalNumberOfFailures;
    }

    public void setTotalNumberOfFailures(List<Integer> totalNumberOfFailures) {
        this.totalNumberOfFailures = totalNumberOfFailures;
    }

    public List<String> getChartLabels() {
        return chartLabels;
    }

    public void setChartLabels(List<String> chartLabels) {
        this.chartLabels = chartLabels;
    }
}
