package com.metakeep.dadc.repository;

import com.metakeep.dadc.model.Analytics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface AnalyticsRepository extends CrudRepository<Analytics, String>, JpaRepository<Analytics, String> {
    @Query("SELECT COUNT(DISTINCT a.userID) FROM Analytics a")
    long countDistinctUserIds();

    Page<Analytics> findByCreatedAtBefore(LocalDateTime endDate, Pageable pageable);

    Page<Analytics> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
}
