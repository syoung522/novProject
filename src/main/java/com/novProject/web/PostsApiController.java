/*
* Web Layer, 브라우저의 요청, 응답 처리
* Create(등록), Read(조회), Update(수정), Delete(삭제)
*/

package com.novProject.web;

import com.novProject.service.posts.PostsService;
import com.novProject.web.dto.PostsResponseDto;
import com.novProject.web.dto.PostsSaveRequestDto;
import com.novProject.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    //js의 url 요청을 받아 오는 곳
    @PostMapping("/api/v1/posts") //등록
    public Long save(@RequestBody PostsSaveRequestDto requestDto){ 
        return postsService.save(requestDto); 
    }

    @PutMapping("/api/v1/posts/{id}") //수정
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}") //조회
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}") //삭제
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
