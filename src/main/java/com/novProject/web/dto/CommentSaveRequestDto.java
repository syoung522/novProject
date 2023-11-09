package com.novProject.web.dto;


import com.novProject.domain.comment.Comment;
import com.novProject.domain.posts.Posts;
import com.novProject.domain.user.User;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CommentSaveRequestDto {
    private Long id;
    private String content;
    private Posts posts;
    private User user;

    public CommentSaveRequestDto(Comment entity){ //entity -> dto
        this.id = entity.getId();
        this.content = entity.getContent();
        this.posts = entity.getPosts();
        this.user = entity.getUser();
    }

    public Comment toEntity() {
        return Comment.builder()
                .id(id)
                .content(content)
                .posts(posts)
                .user(user)
                .build();
    }
}
