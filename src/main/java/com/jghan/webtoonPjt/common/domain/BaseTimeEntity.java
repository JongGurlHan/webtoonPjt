package com.jghan.webtoonPjt.common.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public class BaseTimeEntity {

    @CreatedDate
    @Column(updatable = false)
    protected LocalDateTime createdDate;
    //private String createdDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));


    @LastModifiedDate
    protected LocalDateTime lastModifiedDate;
    //private String lastModifiedDate= LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
}
