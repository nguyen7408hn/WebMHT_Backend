package com.mht.my_web.repository;

import com.mht.my_web.entity.ThuTuNoiDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface ThuTuNoiDonRepository extends JpaRepository<ThuTuNoiDon,Long> {
    @Modifying
    @Query("UPDATE ThuTuNoiDon t SET t.thutu = t.thutu + 1 WHERE t.thutu >= :thutu")
    void incrementOrderForSubsequentLocations(@Param("thutu") Long thutu);

    @Modifying
    @Query("UPDATE ThuTuNoiDon t SET t.thutu = t.thutu - 1 WHERE t.thutu > :thutu")
    void decrementOrderForSubsequentLocations(@Param("thutu") Long thutu);

}
