// Controller Layer, Service Layer에서 사용할 Dto 클래스
// 조회
package com.novProject.web.dto;

import com.novProject.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostsResponseDto {
    private Long id; //게시글 id
    private String title;
    private String content;
    private String author;
    private String category;
    private LocalDate createdDate;
    private List<CommentListResponseDto> comments;

    public PostsResponseDto(Posts entity){ //엔티티 객체(Posts)를 인자로 받아 DTO 객체로 변환하는 역할을 하는 생성자. 엔티티 객체에서 필요한 정보를 추출하여 DTO 객체의 필드에 설정함
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.category = entity.getCategory();
        this.createdDate = entity.getCreatedDate();
        this.comments = entity.getComments().stream().map(CommentListResponseDto::new).collect(Collectors.toList());

    }

}
