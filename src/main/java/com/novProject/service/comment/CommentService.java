package com.novProject.service.comment;

import com.novProject.config.auth.dto.SessionUser;
import com.novProject.domain.comment.Comment;
import com.novProject.domain.comment.CommentRepository;
import com.novProject.domain.posts.Posts;
import com.novProject.domain.posts.PostsRepository;
import com.novProject.domain.user.User;
import com.novProject.domain.user.UserRepository;
import com.novProject.web.dto.CommentListResponseDto;
import com.novProject.web.dto.CommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostsRepository postsRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(Long id, CommentSaveRequestDto requestDto, String userName){ //저장

        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다." + id));

        User user = userRepository.findByName(userName);

        requestDto.setUser(user);
        requestDto.setPosts(posts);

        Comment comment = requestDto.toEntity();
        commentRepository.save(comment);

        return requestDto.getId();

    }

//    @Transactional
//    public CommentListResponseDto findById(Long id){
//        Comment entity = commentRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id=" + id));
//        return new CommentListResponseDto(entity);
//    }
}
