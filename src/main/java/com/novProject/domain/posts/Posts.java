//Entity 클래스
//게시글(Posts) 정보를 저장하고 수정하는 데 사용되는 엔티티 클래스이다.

package com.novProject.domain.posts;

import com.novProject.domain.BaseTimeEntity;
import com.novProject.domain.comment.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter//클래스 내 모든 필드의 getter 메소드 자동 생성 //lombok
@NoArgsConstructor //초기화되지 않은 final 키워드를 사용한 필드에 생성자를 생성해줌 //lombok
@Entity //테이블과 매칭될 클래스
public class Posts extends BaseTimeEntity {

    @Id //테이블의 PK(Primary Key)필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙 (자동 증가(Auto Increment) 방식)
    @Column(name = "posts_id")
    private Long id;

    @Column(name = "posts_title", length = 500, nullable = false) //테이블의 칼럼 (길이 500, null 불가능)
    private String title;
    @Column(name = "posts_content", columnDefinition = "TEXT", nullable = false)
    private String content;
    @Column(name = "posts_author", nullable = false)
    private String author;
    @Column(name = "posts_category", nullable = false)
    private String category;

    @OneToMany(mappedBy = "posts")
    private List<Comment> comments;

    @Builder //lombok
    public Posts(String title, String content, String author, String category, List<Comment> comments){
        this.title = title;
        this.content = content;
        this.author = author;
        this.category = category;
        this.comments = comments;
    }

    //게시글을 수정하기 위한 메소드. 제목과 내용을 인자로 받아 업데이트함
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
