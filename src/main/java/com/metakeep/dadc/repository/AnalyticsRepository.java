package com.metakeep.dadc.repository;

import com.metakeep.dadc.model.Analytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AnalyticsRepository extends CrudRepository<Analytics, String>, JpaRepository<Analytics, String> {
}
