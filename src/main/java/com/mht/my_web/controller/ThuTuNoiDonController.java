package com.mht.my_web.controller;

import com.mht.my_web.dto.request.ThuTuNoiDonCreationRequest;
import com.mht.my_web.entity.ThuTuNoiDon;
import com.mht.my_web.service.ThuTuNoiDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ThuTuNoiDon")
public class ThuTuNoiDonController {
    @Autowired
    private ThuTuNoiDonService ThuTuNoiDonService;

    @PostMapping
    ThuTuNoiDon createThuTuNoiDon(@RequestBody ThuTuNoiDonCreationRequest request) {
        return ThuTuNoiDonService.createThuTuNoiDon(request);
    }

    @GetMapping
    List<ThuTuNoiDon> getThuTuNoiDons() {
        return ThuTuNoiDonService.getThuTuNoiDons();
    }

    @GetMapping("/{id}")
    ThuTuNoiDon getThuTuNoiDon(@PathVariable Long id) {
        return ThuTuNoiDonService.getThuTuNoiDon(id);
    }

    @PutMapping("/{id}")
    public ThuTuNoiDon updateThuTuNoiDon(@PathVariable Long id, @RequestBody ThuTuNoiDonCreationRequest request) {
        return ThuTuNoiDonService.updateThuTuNoiDon(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteThuTuNoiDon(@PathVariable Long id) {
        ThuTuNoiDonService.deleteThuTuNoiDon(id);
    }
}
