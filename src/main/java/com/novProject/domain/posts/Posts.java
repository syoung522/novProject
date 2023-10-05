package com.novProject.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter//클래스 내 모든 필드의 getter 메소드 자동 생성 //lombok
@NoArgsConstructor //초기화되지 않은 final 키워드를 사용한 필드에 생성자를 생성해줌 //lombok
@Entity //테이블과 매칭될 클래스
public class Posts {

    @Id //테이블의 PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 칼럼
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //lombok
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
