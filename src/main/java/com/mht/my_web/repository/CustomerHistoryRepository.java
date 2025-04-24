package com.mht.my_web.repository;

import com.mht.my_web.entity.CustomerHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.OffsetDateTime;
import java.util.List;

public interface CustomerHistoryRepository extends JpaRepository<CustomerHistory, Long> {
    List<CustomerHistory> findTop5BySdtOrderByCreatedAtDesc(String sdt);
    List<CustomerHistory> findAllByCreatedAtBetweenOrderByCreatedAtDesc(OffsetDateTime start, OffsetDateTime end);

    @Query("SELECT DISTINCT ch.noidi FROM CustomerHistory ch WHERE ch.noidi IS NOT NULL")
    List<String> findAllDistinctNoidi();
}
