package com.novProject.domain.comment;

import com.novProject.domain.BaseTimeEntity;
import com.novProject.domain.posts.Posts;
import com.novProject.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "comment_content", nullable = false, length = 500)
    private String content;

    @ManyToOne
    @JoinColumn(name = "posts_id", nullable = false)
    private Posts posts;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Comment(Long id, String content, Posts posts, User user) {
        this.id = id;
        this.content = content;
        this.posts = posts;
        this.user = user;
    }
}
