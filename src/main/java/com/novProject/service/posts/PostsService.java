// Service Layer, 비즈니스 로직

package com.novProject.service.posts;

import com.novProject.domain.posts.PostsRepository;
import com.novProject.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor //초기화되지 않은 final 키워드를 사용한 필드에 생성자를 생성해줌
@Service //로직을 처리하는 서비스 레이어임을 알림
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
