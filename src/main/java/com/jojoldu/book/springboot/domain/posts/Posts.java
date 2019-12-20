package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //기본 생성자 자동 추가
@Entity //테이블과 링크될 클래스임을 나타냄 , 기본값으로 클래스 카멜케이스 이름을 언더스코어네이밍으로 테이블이름을 매칭
public class Posts extends BaseTimeEntity {
    @Id //해당 테이블의 PK 필드를 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙을 나타냄  GenerationType.IDENTITY
    private Long id;                                     //은 outo_increment 옵션

    @Column(length = 500 , nullable =false) //테이블 칼럼을 나타내며 선언하지 않아도 해당 클래스의 필드는 컬럼이됨
    private String title;         // 변경이 필요한 옵션이 있으면 사용(varchar 기본값 255)

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스를 생성 , 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title , String content ,String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
