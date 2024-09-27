package com.mht.my_web.entity;
import jakarta.persistence.*;

@Entity
@Table(name="thutunoidon")
public class ThuTuNoiDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String noidon;
    private Long thutu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoidon() {
        return noidon;
    }

    public void setNoidon(String noidon) {
        this.noidon = noidon;
    }

    public Long getThutu() {
        return thutu;
    }
    public void setThutu(Long thutu) {
        this.thutu = thutu;
    }
}
