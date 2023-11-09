package com.novProject.web.dto;

import com.novProject.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;

    //private LocalDateTime modifiedDate;
    private LocalDate createdDate;
    private String category;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        //this.modifiedDate = entity.getModifiedDate();
        this.createdDate = entity.getCreatedDate();
        this.category = entity.getCategory();
    }
}