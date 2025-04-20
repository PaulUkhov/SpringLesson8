package org.example.soringlesson8homework.model.task2;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.security.Timestamp;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable {
    @CreatedDate
    @Column(updatable = false)
    private Timestamp createdAt;
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedAt;
}
