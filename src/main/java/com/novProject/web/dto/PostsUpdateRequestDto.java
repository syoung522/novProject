// Controller Layer, Service Layer에서 사용할 Dto 클래스
// 수정
package com.novProject.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;
    private String category;

    public PostsUpdateRequestDto(String title, String content, String category){
        this.title = title;
        this.content = content;
        this.category = category;
    }
}
