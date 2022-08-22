package com.tosan.bookstore.models;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    @Version
    private Integer version;

    @CreatedDate
    private LocalDateTime createdDate;

    @CreatedBy
    @Column(length = 40)
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @LastModifiedBy
    @Column(length = 40)
    private String lastModifiedBy;

    @Column(name = "deleted")
    private Boolean deleted = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity that)) return false;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}