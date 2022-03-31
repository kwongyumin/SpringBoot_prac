package com.sparta.spartaproject01.model;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@MappedSuperclass //상속받는 자식 클래스에게 부모의 멤버를 컬럼으로 인식하도록한다.
@Getter
@EntityListeners(AuditingEntityListener.class)
// 자동적으로 시간 업데이트 , 변동사항이 있으면 알려준다,
public abstract class Timestamped {

    @CreatedDate
    private LocalDateTime createAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;


}
