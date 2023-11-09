package com.novProject.web.dto;

import com.novProject.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostsViewDto {
    private Long id;
    private String category;
    private LocalDate createdDate;
    private String title;
    private String author;
    private String content;
    private List<CommentListResponseDto> comments;

    public PostsViewDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.category = entity.getCategory();
        this.createdDate = entity.getCreatedDate();
        this.comments = entity.getComments().stream().map(CommentListResponseDto::new).collect(Collectors.toList());
    }

}
