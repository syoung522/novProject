package com.novProject.web.dto;

import com.novProject.domain.comment.Comment;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CommentListResponseDto {
    private String userName;
    private LocalDate createdDate;
    private String content;
//    private Long postsId;

    public CommentListResponseDto(Comment entity){ //entity -> dto
        this.content = entity.getContent();
        this.createdDate = entity.getCreatedDate();
//        this.postsId = entity.getPosts().getId();
        this.userName = entity.getUser().getName();
    }
}
