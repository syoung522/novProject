//Entity 클래스
//게시글(Posts) 정보를 저장하고 수정하는 데 사용되는 엔티티 클래스이다.

package com.novProject.domain.posts;

import com.novProject.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter//클래스 내 모든 필드의 getter 메소드 자동 생성 //lombok
@NoArgsConstructor //초기화되지 않은 final 키워드를 사용한 필드에 생성자를 생성해줌 //lombok
@Entity //테이블과 매칭될 클래스
public class Posts extends BaseTimeEntity { //Posts라는 테이블이 id, title, content, author 컬럼을 가지고있음

    @Id //테이블의 PK(Primary Key)필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙 (자동 증가(Auto Increment) 방식)
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 칼럼 (길이 500, null 불가능)
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

    //게시글을 수정하기 위한 메소드. 제목과 내용을 인자로 받아 업데이트함
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
