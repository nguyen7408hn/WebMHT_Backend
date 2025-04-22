package com.mht.my_web.controller;

import org.springframework.format.annotation.DateTimeFormat; // ✅ cần cho @DateTimeFormat
import java.time.LocalDate;          // ✅ cần cho LocalDate
import java.time.LocalDateTime;      // ✅ cần cho LocalDateTime
import com.mht.my_web.entity.CustomerHistory;
import com.mht.my_web.repository.CustomerHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CustomerHistory")
@RequiredArgsConstructor
public class CustomerHistoryController {

    private final CustomerHistoryRepository repository;

    @PostMapping
    public CustomerHistory save(@RequestBody CustomerHistory history) {
        return repository.save(history);
    }

    @GetMapping
    public List<CustomerHistory> getHistoryBySdt(@RequestParam String sdt) {
        return repository.findTop5BySdtOrderByCreatedAtDesc(sdt);
    }

    @GetMapping("/by-date")
    public List<CustomerHistory> getByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.plusDays(1).atStartOfDay();
        return repository.findAllByCreatedAtBetweenOrderByCreatedAtDesc(start, end);
    }
}
