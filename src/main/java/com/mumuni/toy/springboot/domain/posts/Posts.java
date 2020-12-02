package com.mumuni.toy.springboot.domain.posts;

import com.mumuni.toy.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본생성자 자동 추가(lombok)
@Entity // jpa annotation : 테이블과 링크될 클래스임을 나타냄, 기본값으로 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름 매칭
        // entity 클래스의 경우 유지보수를 위해 getter, setter 를 선언하지 않는다.
        // response, request 처럼 사용하지 말 것, 해당 클래스는 DB와 맞닿는 핵심클래스, 해당 변경은 이 클래스를 이용하는 모든 서비스에 큰 영향을 준다.
public class Posts extends BaseTimeEntity {
    @Id //jpa 해당 테이블의 pk필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // jpa pk 생성규칙 : auto_increase 옵션
    private Long id;

    @Column(length = 500, nullable = false) // jpa 테이블칼럼 : 없어도 필드값은 컬럼으로 인식함, 추가필요 옵션이 있을 경우 선언
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // jpa 영속성 컨텍스트로 인한 쿼리 내용이 없음
    // 트랜잭션이 끝나는 시점에서 해당 테이블에 변경분을 반영함 (dirty checking)
    public void update (String title, String content) {
        this.title = title;
        this.content = content;
    }
}
