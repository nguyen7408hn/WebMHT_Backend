package com.mht.my_web.entity;

import jakarta.persistence.*;

@Entity
@Table(name="customers9H")
public class Customer9H {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sdt;
    private int sove;
    private String noidon;
    private String noidi;
    private String ghichu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getSove() {
        return sove;
    }

    public void setSove(int sove) {
        this.sove = sove;
    }

    public String getNoidon() {
        return noidon;
    }

    public void setNoidon(String noidon) {
        this.noidon = noidon;
    }

    public String getNoidi() {
        return noidi;
    }

    public void setNoidi(String noidi) {
        this.noidi = noidi;
    }

    public String getGhichu() {return ghichu;}

    public void setGhichu(String ghichu) {this.ghichu = ghichu;}
}


