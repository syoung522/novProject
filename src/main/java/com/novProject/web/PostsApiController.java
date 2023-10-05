// Web Layer, 브라우저 요청 응답

package com.novProject.web;

import com.novProject.service.posts.PostsService;
import com.novProject.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor //초기화되지 않은 final 키워드를 사용한 필드에 생성자를 생성해줌
@RestController //controller임을 알림 //JSON형태의 객체 데이터 반환
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
}
