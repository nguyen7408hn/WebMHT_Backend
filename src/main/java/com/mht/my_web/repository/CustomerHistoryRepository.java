package com.mht.my_web.repository;

import com.mht.my_web.entity.CustomerHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;

import java.util.List;

public interface CustomerHistoryRepository extends JpaRepository<CustomerHistory, Long> {
    List<CustomerHistory> findTop5BySdtOrderByCreatedAtDesc(String sdt);
    List<CustomerHistory> findAllByCreatedAtBetweenOrderByCreatedAtDesc(LocalDateTime start, LocalDateTime end);
}
