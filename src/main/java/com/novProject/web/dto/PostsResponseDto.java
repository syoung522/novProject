// Controller Layer, Service Layer에서 사용할 Dto 클래스
// 조회
package com.novProject.web.dto;

import com.novProject.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id; //게시글 id
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();

    }

}
