package com.novProject.web;

import com.novProject.config.auth.LoginUser;
import com.novProject.config.auth.dto.SessionUser;
import com.novProject.service.comment.CommentService;
import com.novProject.web.dto.CommentSaveRequestDto;
import com.novProject.web.dto.UserSessionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final CommentService commentService;

    @PostMapping("/api/posts/{id}/comments")
    public Long save(@PathVariable Long id,
                     @RequestBody CommentSaveRequestDto requestDto,
                     @LoginUser SessionUser user){
        System.out.println(requestDto.getId());
        String userName = user.getName();
        return commentService.save(id, requestDto, userName);
    }
}
