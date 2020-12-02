package com.mumuni.toy.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // jpa entitiy 클래스들이 이 클래스를 상속할 경우, 필드들도 컬럼으로 인식하도록 합니다.
@EntityListeners(AuditingEntityListener.class) // 해당 클래스에 Auditing 기능을 포함시킵니다 (자동 값 입력)
public abstract class BaseTimeEntity {
    @CreatedDate // Entity 가 생성되어 저장될 때 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 Entity 의 값이 변경될 때 저장
    private LocalDateTime modifiedDate;

}
