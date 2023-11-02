package com.novProject.web.dto;

import com.novProject.domain.posts.Posts;
import lombok.Getter;
import java.time.LocalDateTime;
@Getter
public class PostsViewDto {
    private Long id;
    private String category;
    private LocalDateTime createdDate;
    private String title;
    private String author;
    private String content;

    public PostsViewDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.category = entity.getCategory();
        this.createdDate = entity.getCreatedDate();
    }

}
