// Service Layer, 비즈니스 로직 (table에 대한 CRUD 로직을 작성하는 곳)

package com.novProject.service.posts;

import com.novProject.domain.comment.CommentRepository;
import com.novProject.domain.posts.Posts;
import com.novProject.domain.posts.PostsRepository;
import com.novProject.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){ //저장
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){ //수정 (Posts 엔티티에 도메인 로직 위임)
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        posts.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getCategory());
        return id;
    }
    @Transactional
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }

//    @Transactional
//    public PostsViewDto findPostById(Long id){
//        Posts entity = postsRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
//        return new PostsViewDto(entity);
//    }


    @Transactional(readOnly = true)
    public Page<Posts> findAllDesc(Pageable pageable) {
        return postsRepository.findAllDesc(pageable);
//                .stream()
//                .map(PostsListResponseDto::new)
//                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new
                        IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        postsRepository.delete(posts);
    }

    @Transactional
    public Page<Posts> findByTitleContaining(String keyword_2, Pageable pageable){
        return postsRepository.findByTitleContaining(keyword_2, pageable);
    }
    @Transactional
    public Page<Posts> findByCategoryAndTitleContaining(String keyword_1, String keyword_2, Pageable pageable){
        return postsRepository.findByCategoryAndTitleContaining(keyword_1, keyword_2, pageable);
    }
}
