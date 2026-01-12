package com.mht.my_web.controller;

import com.mht.my_web.entity.CustomerHistory;
import com.mht.my_web.repository.CustomerHistoryRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://lmkn.netlify.app")
@RequestMapping("/CustomerHistory")
public class CustomerHistoryController {

    private final CustomerHistoryRepository repository;

    // ← Thêm constructor này để Spring inject đúng bean
    public CustomerHistoryController(CustomerHistoryRepository repository) {
        this.repository = repository;
    }

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
        OffsetDateTime start = date.atStartOfDay().atOffset(ZoneOffset.ofHours(+7));
        OffsetDateTime end = date.plusDays(1).atStartOfDay().atOffset(ZoneOffset.ofHours(+7));
        return repository.findAllByCreatedAtBetweenOrderByCreatedAtDesc(start, end);
    }

    @GetMapping("/allnoidi")
    public List<String> getAllNoiDi() {
        return repository.findAllDistinctNoidi();
    }
}
