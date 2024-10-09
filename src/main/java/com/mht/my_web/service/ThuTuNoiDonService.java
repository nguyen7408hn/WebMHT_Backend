package com.mht.my_web.service;

import com.mht.my_web.dto.request.ThuTuNoiDonCreationRequest;
import com.mht.my_web.entity.ThuTuNoiDon;
import com.mht.my_web.repository.ThuTuNoiDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.mht.my_web.exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Collectors;

@Service
public class ThuTuNoiDonService {

    @Autowired
    private ThuTuNoiDonRepository ThuTuNoiDonRepository;
    
    @Transactional
    public ThuTuNoiDon createThuTuNoiDon(ThuTuNoiDonCreationRequest request) {

        ThuTuNoiDonRepository.incrementOrderForSubsequentLocations(request.getThutu());
        // Tạo đối tượng ThuTuNoiDon từ request
        ThuTuNoiDon thutu = new ThuTuNoiDon();
        thutu.setNoidon(request.getNoidon());
        thutu.setThutu(request.getThutu());

        return ThuTuNoiDonRepository.save(thutu);
    }

    public List<ThuTuNoiDon> getThuTuNoiDons() {
        return ThuTuNoiDonRepository.findAll();
    }

    public ThuTuNoiDon getThuTuNoiDon(Long id) {
        return ThuTuNoiDonRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ThuTuNoiDon not found with id: " + id));
    }

    public ThuTuNoiDon updateThuTuNoiDon(Long id, ThuTuNoiDonCreationRequest request) {
        Optional<ThuTuNoiDon> existingThuTuNoiDon = ThuTuNoiDonRepository.findById(id);

        if (existingThuTuNoiDon.isPresent()) {
            ThuTuNoiDon thutu = existingThuTuNoiDon.get();
            // Update fields
            thutu.setThutu(request.getThutu());
            thutu.setNoidon(request.getNoidon());
            return ThuTuNoiDonRepository.save(thutu);
        } else {
            throw new RuntimeException("ThuTuNoiDon not found with id: " + id);
        }
    }

    @Transactional
    public void deleteThuTuNoiDon(Long id) {
        // Tìm địa điểm cần xóa để lấy thứ tự của nó
        Optional<ThuTuNoiDon> locationToDelete = ThuTuNoiDonRepository.findById(id);

        if (locationToDelete.isPresent()) {
            Long thutu = locationToDelete.get().getThutu();

            // Xóa địa điểm
            ThuTuNoiDonRepository.deleteById(id);

            // Giảm thứ tự cho các địa điểm có thứ tự lớn hơn
            ThuTuNoiDonRepository.decrementOrderForSubsequentLocations(thutu);
        } else {
            throw new ResourceNotFoundException("ThuTuNoiDon not found with id: " + id);
        }
    }

    public List<ThuTuNoiDon> getSuggestions(String partialName) {
        return ThuTuNoiDonRepository.findByNoidonContainingIgnoreCase(partialName);
    }
}
