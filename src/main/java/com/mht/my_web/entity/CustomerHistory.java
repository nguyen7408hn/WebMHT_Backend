package com.mht.my_web.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sdt;
    private String sove;
    private String noidon;
    private String noidi;
    private String ghichu;

    private String tai; // ✅ Cột mới để lưu Tài (ví dụ: "Tài 1h")

    private OffsetDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = OffsetDateTime.now(ZoneOffset.UTC);
    }
}
